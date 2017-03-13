package co.nri.micasa.etra.tasklet;

import co.nri.micasa.common.MQTTPublishTasklet;
import co.nri.micasa.etra.model.TrashType;
import java.util.List;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class EtraPublishTasklet extends MQTTPublishTasklet {
    
    private static final String CLIENT_ID = "EtraCalendar";
    
    @Value("${etra.topic}")
    protected String publishTopic;
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        ExecutionContext jobContext = chunkContext.getStepContext()
                                    .getStepExecution()
                                    .getJobExecution()
                                    .getExecutionContext();
        List<TrashType> trashTypes = (List<TrashType>) jobContext.get("tomorrowTypes");
        String result = null;
        if(trashTypes != null && !trashTypes.isEmpty()) {
            result = StringUtils.collectionToDelimitedString(trashTypes, ",");
        }
        this.publish(publishTopic, result);
        return RepeatStatus.FINISHED;
    }

    @Override
    protected String getClientId() {
        return CLIENT_ID;
    }
}
