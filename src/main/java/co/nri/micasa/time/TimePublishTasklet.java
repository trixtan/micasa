package co.nri.micasa.time;

import co.nri.micasa.MQTTPublishTasklet;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TimePublishTasklet extends MQTTPublishTasklet {
    
    private static final String CLIENT_ID = "TimePublisher";
    
    @Value("${time.topic}")
    protected String publishTopic;
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        this.publish(publishTopic, System.currentTimeMillis());
        return RepeatStatus.FINISHED;
    }

    @Override
    protected String getClientId() {
        return CLIENT_ID;
    }
}
