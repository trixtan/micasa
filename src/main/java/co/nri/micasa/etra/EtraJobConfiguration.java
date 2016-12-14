package co.nri.micasa.etra;

import co.nri.micasa.etra.tasklet.EtraFetchTasklet;
import co.nri.micasa.etra.tasklet.EtraPublishTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EtraJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private EtraFetchTasklet etraFetchTasklet;

    @Autowired
    private EtraPublishTasklet etraPublishTasklet;

    @Bean
    public Step etraFetchStep(ExecutionContextPromotionListener etraTomorrowTypesPromotionListener) {
        return stepBuilderFactory.get("etraFetchStep")
                .tasklet(etraFetchTasklet)
                .listener(etraTomorrowTypesPromotionListener)
                .build();
    }

    @Bean
    public Step etraPublishStep() {
        return stepBuilderFactory.get("etraPublishStep")
                .tasklet(etraPublishTasklet)
                .build();
    }

    @Bean
    public Job etraJob(
            Step etraFetchStep,
            Step etraPublishStep) throws Exception {
        return jobBuilderFactory.get("etraJob")
                .incrementer(new RunIdIncrementer())
                .start(etraFetchStep)
                .next(etraPublishStep)
                .build();
    }

    @Bean
    public ExecutionContextPromotionListener etraTomorrowTypesPromotionListener() {
        ExecutionContextPromotionListener toRet = new ExecutionContextPromotionListener();
        toRet.setKeys(new String[]{"tomorrowTypes"});
        return toRet;
    }

}
