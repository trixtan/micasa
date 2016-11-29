package co.nri.micasa.trenitime.tasklet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.nri.micasa.trenitime.model.in.viaggiatreno.soluzioniViaggioNew.Soluzione;
import co.nri.micasa.trenitime.model.in.viaggiatreno.soluzioniViaggioNew.SoluzioniViaggioNewResponse;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;

@Component
public class FetchSoluzioniViaggioTasklet implements Tasklet {

    private static final Logger LOG = LoggerFactory.getLogger(FetchSoluzioniViaggioTasklet.class);

    private static final String CONFIG_PLACEHOLDER_PREFIX = "{";
    private static final String CONFIG_PLACEHOLDER_SUFFIX = "}";

    private static final SimpleDateFormat soluzioniViaggioDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private static final Pattern STATION_ID_PATTERN = Pattern.compile("(S0*)(.*)");

    @Value("${trenitime.endpoint.viaggiatreno.soluzioniViaggioNew}")
    private String soluzioniViaggioNewUrl;

    @Value("${trenitime.fromStation}")
    private String fromStation;

    @Value("${trenitime.toStation}")
    private String toStation;
    
    private StepExecution stepExecution;
    
    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        Map<String, Soluzione> soluzioni = getSoluzioni();
        if(soluzioni != null) {
            this.stepExecution.getExecutionContext().put("soluzioniViaggio", soluzioni);
            return RepeatStatus.CONTINUABLE;
        } else {
            return RepeatStatus.FINISHED;
        }
    }

    private Map<String, Soluzione> getSoluzioni() {
        //Get all solutions from now
        Map<String, String> placeholders = new HashMap<>();
        placeholders.put("date", soluzioniViaggioDateFormat.format(Calendar.getInstance().getTime()));
        placeholders.put("fromStation", stripStationId(this.fromStation));
        placeholders.put("toStation", stripStationId(this.toStation));
        RestTemplate restTemplate = new RestTemplate();
        try {
            SoluzioniViaggioNewResponse response =  restTemplate.getForObject(
                    StrSubstitutor.replace(this.soluzioniViaggioNewUrl, placeholders, CONFIG_PLACEHOLDER_PREFIX, CONFIG_PLACEHOLDER_SUFFIX),
                    SoluzioniViaggioNewResponse.class);
            if(StringUtils.isNotBlank(response.getErrore())){
                LOG.error("Can't load soluzioni. Error was {}", response.getErrore());
                return null;
            } else {
                Map<String, Soluzione> soluzioni = new HashMap<>();
                response.getSoluzioni().stream().forEach((s) -> {
                    soluzioni.put(s.getVehicles().get(0).getNumeroTreno(), s);
                });
                return soluzioni;
            }
        } catch(Exception e) {
            LOG.error("Can't get data from url {}", this.soluzioniViaggioNewUrl, e);
            return null;
        }
    }

    private String stripStationId(String stationId) {
        Validate.notEmpty(stationId);
        Matcher matcher = STATION_ID_PATTERN.matcher(stationId);
        if(matcher.find()) {
            return matcher.group(2);
        }
        return stationId;
    }
}
