package co.nri.micasa.trenitime.tasklet;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import co.nri.micasa.trenitime.model.in.viaggiatreno.partenze.PartenzaIn;
import co.nri.micasa.trenitime.model.in.viaggiatreno.soluzioniViaggioNew.Soluzione;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.http.HttpStatus;

@Component
public class FetchPartenzeTasklet implements Tasklet {

    private static final Logger LOG = LoggerFactory.getLogger(FetchPartenzeTasklet.class);

    private static final SimpleDateFormat partenzeDateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);

    private static final String CONFIG_PLACEHOLDER_PREFIX = "{";
    private static final String CONFIG_PLACEHOLDER_SUFFIX = "}";

    @Value("${trenitime.endpoint.viaggiatreno.partenze}")
    private String partenzeUrl;

    @Value("${trenitime.fromStation}")
    private String fromStation;

    @Value("${trenitime.toStation}")
    private String toStation;
    
    private StepExecution stepExecution;
    private Map<String, Soluzione> soluzioniViaggio;
    
    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
        this.soluzioniViaggio = (Map<String, Soluzione>) this.stepExecution.getJobExecution().getExecutionContext().get("soluzioniViaggio");
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        List<PartenzaIn> partenze = getPartenze();
        this.stepExecution.getExecutionContext().put("partenze", partenze);
        return RepeatStatus.FINISHED;
    }

    private List<PartenzaIn> getPartenze() throws UnsupportedEncodingException {
        Map<String, String> placeholders = new HashMap<>();
        placeholders.put("date", partenzeDateFormat.format(Calendar.getInstance().getTime()));
        placeholders.put("fromStation", this.fromStation);

        RestTemplate restTemplate = new RestTemplate();
        String url = StrSubstitutor.replace(this.partenzeUrl, placeholders, CONFIG_PLACEHOLDER_PREFIX, CONFIG_PLACEHOLDER_SUFFIX);
        ResponseEntity<List<PartenzaIn>> partenzeResponse = null;
        try {
            partenzeResponse =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<PartenzaIn>>() {
                            });

            List<PartenzaIn> partenzeListOut = new ArrayList<>();
            if(partenzeResponse.getStatusCode() != HttpStatus.OK){
                LOG.error("Can't load partenze. HttpStatus was {}", partenzeResponse.getStatusCode());
            } else {
                List<PartenzaIn> partenzeListIn = partenzeResponse.getBody();
                LocalDateTime now = LocalDateTime.now();
                partenzeListIn
                        .stream()
                        .filter((p) -> (
                                this.soluzioniViaggio.containsKey(Integer.toString(p.getNumeroTreno())))
                        )
                        .map((p) -> {
                            p.setOrarioPartenza(p.getOrarioPartenza() + (p.getRitardo() * 1000));
                            p.setCategoria(this.soluzioniViaggio.get(Integer.toString(p.getNumeroTreno())).getVehicles().get(0).getCategoriaDescrizione());
                            return p;
                        })
                        .filter((p) -> (
                                p.getOrarioPartenza() > now.atZone(ZoneId.systemDefault()).toEpochSecond()*1000)
                        )
                        .forEach((p) -> {
                            partenzeListOut.add(p);
                        });

                //sort
                Collections.sort(partenzeListOut, (o1, o2) -> o1.getOrarioPartenza().compareTo(o2.getOrarioPartenza()));
            }
            return partenzeListOut;
        } catch(HttpClientErrorException e) {
            LOG.error("Can't get data from url: {}. Response body was: {}", url, e.getResponseBodyAsString(), e);
            return null;
        }
    }
}
