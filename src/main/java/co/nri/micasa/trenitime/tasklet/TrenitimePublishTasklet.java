package co.nri.micasa.trenitime.tasklet;

import co.nri.micasa.MQTTPublishTasklet;
import co.nri.micasa.trenitime.model.in.viaggiatreno.partenze.PartenzaIn;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class TrenitimePublishTasklet extends MQTTPublishTasklet {
    
    private static final String CLIENT_ID = "TreniTime";
    
    
    private String partenzeTopic;

    private StepExecution stepExecution;    
    private List<PartenzaIn> partenze;
    
    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
        this.partenze = (List<PartenzaIn>) this.stepExecution.getJobExecution().getExecutionContext().get("partenze");
        this.partenzeTopic = this.stepExecution.getJobParameters().getString("topic");
    }
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        Integer timeNext = -1;
        if(!CollectionUtils.isEmpty(this.partenze)) {
            LocalDateTime timeNextDT = LocalDateTime.ofInstant(Instant.ofEpochMilli(this.partenze.get(0).getOrarioPartenza()), ZoneId.systemDefault());
            timeNext = timeNextDT.getMinute();
        }
        this.publish(this.partenzeTopic, Integer.toString(timeNext));
        return RepeatStatus.FINISHED;
    }

    @Override
    protected String getClientId() {
        return CLIENT_ID;
    }
}
