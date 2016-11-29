package co.nri.micasa.etra;

import co.nri.micasa.MQTTPublishTasklet;
import java.util.Collections;
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
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        ExecutionContext jobContext = chunkContext.getStepContext()
                                    .getStepExecution()
                                    .getJobExecution()
                                    .getExecutionContext();
        List<EtraBatchConfiguration.TRASH_TYPE> trashTypes = (List<EtraBatchConfiguration.TRASH_TYPE>) jobContext.get("tomorrowTypes");
        String result = null;
        if(trashTypes != null && !trashTypes.isEmpty()) {
            result = StringUtils.collectionToDelimitedString(trashTypes, ",");
        }
        this.publish("etra/garbagecollection/tomorrow", result);
        return RepeatStatus.FINISHED;
    }

    @Override
    protected String getClientId() {
        return CLIENT_ID;
    }
}
