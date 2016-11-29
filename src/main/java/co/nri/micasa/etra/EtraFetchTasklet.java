package co.nri.micasa.etra;

import com.ctc.wstx.api.WstxInputProperties;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.codehaus.stax2.XMLInputFactory2;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class EtraFetchTasklet implements Tasklet{
    
    @Value("${etra.url}")
    private String url;
    @Value("${etra.via}")
    private String via;
    @Value("${etra.civico}")
    private String civico;
    @Value("${etra.tipoUtenza}")
    private String tipoUtenza;
   
    private enum CurrentElement {DAY, TYPE};
     
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        makeRequest(chunkContext);
        return RepeatStatus.FINISHED;
    }
    
    private void makeRequest(ChunkContext chunkContext) throws IOException, XMLStreamException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        String body = "via=" + via + "&civico=" + civico + "&tipoUtenza=" + tipoUtenza;
        os.write(body.getBytes());
        os.flush();
        os.close();
	// For POST only - END

	int responseCode = con.getResponseCode();
	
	if (responseCode == HttpURLConnection.HTTP_OK) { //success
              
        XMLInputFactory xmlInputFactory = XMLInputFactory2.newFactory();
        xmlInputFactory.setProperty(WstxInputProperties.P_INPUT_PARSING_MODE, WstxInputProperties.PARSING_MODE_FRAGMENT);
        XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new InputStreamReader(con.getInputStream()));

        int currentTd = 1;
        boolean readTd = false;
        int divsToSkip = 2;
        String day = null, type = null;
        boolean processFinished = false;
            List<EtraBatchConfiguration.TRASH_TYPE> tomorrowTypes = new ArrayList<>();
        
	while (reader.hasNext() && !processFinished) {
            int event = reader.next();
            switch (event) {
            case XMLStreamConstants.START_ELEMENT:
                if(divsToSkip > 0 ) break;
                if ("td".equals(reader.getLocalName())) {
                    switch(currentTd) {
                        case 1:
                            readTd = true;
                            break;
                        case 2:
                            readTd = false;
                            break;
                        case 3:
                            readTd = true;
                            break;
                    }
                }
                break;
 
            case XMLStreamConstants.CHARACTERS:
                if(!readTd) break;
                switch(currentTd) {
                    case 1:
                        day = reader.getText().trim();
                        break;
                    case 3:
                        type = reader.getText().trim();
                        break;
                }
                break;
 
            case XMLStreamConstants.END_ELEMENT:
                switch (reader.getLocalName()) {
                case "td":
                    if(divsToSkip > 0) break;
                    if(currentTd == 3) {
                        int tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
                        if(extractDay(day) == tomorrow) {
                            tomorrowTypes.add(EtraBatchConfiguration.TRASH_TYPE.fromDescription(StringUtils.trimWhitespace(type)));
                        }
                    }
                    currentTd = (currentTd++ % 3) + 1;
                    readTd = false;
                    break;
                case "div":
                    if (divsToSkip > 0) {
                        divsToSkip--;
                    } else if(divsToSkip == 0) {
                        processFinished = true;
                    }
                } 
                break;
 
            case XMLStreamConstants.START_DOCUMENT:
                break;
            }
        }
	reader.close();
        
        ExecutionContext stepContext = chunkContext.getStepContext()
                                    .getStepExecution()
                                    .getExecutionContext();
        stepContext.put("tomorrowTypes", tomorrowTypes);
    }  
    }
    
    private int extractDay(String day) {
        return Integer.parseInt(day.split(" ")[1]);
    }
}
