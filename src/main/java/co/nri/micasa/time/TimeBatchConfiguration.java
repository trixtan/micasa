package co.nri.micasa.time;

import co.nri.micasa.etra.*;
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
public class TimeBatchConfiguration {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;
  
  @Autowired
  private TimePublishTasklet timePublishTasklet;
  
  @Bean
  public Step timePublishStep() {
    return stepBuilderFactory.get("timePublishStep")
        .tasklet(timePublishTasklet)
        .build();
  }

  @Bean
  public Job timeJob(
          Step timePublishStep) throws Exception {
    return jobBuilderFactory.get("timeJob")
        .incrementer(new RunIdIncrementer())
        .start(timePublishStep)
        .build();
  }

}