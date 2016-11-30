package co.nri.micasa.trenitime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.nri.micasa.trenitime.tasklet.FetchPartenzeTasklet;
import co.nri.micasa.trenitime.tasklet.FetchSoluzioniViaggioTasklet;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;

@Configuration
@EnableBatchProcessing
public class TreniTimeJobConfiguration {

    @Bean
    public Job trenitimeJob(
            JobBuilderFactory jobs,
            Step fetchSoluzioniStep,
            Step fetchPartenzeStep) {
        return jobs.get("fetchPartenzeJob")
                .incrementer(new RunIdIncrementer())
                .start(fetchSoluzioniStep)
                .next(fetchPartenzeStep)
                .build();
    }

    @Bean
    public StepExecutionListener soluzioniViaggioPromotionListener() {
        ExecutionContextPromotionListener toRet = new ExecutionContextPromotionListener();
        toRet.setKeys(new String[]{"soluzioniViaggio"});
        return toRet;
    }
    
    @Bean
    public StepExecutionListener oartenzePromotionListener() {
        ExecutionContextPromotionListener toRet = new ExecutionContextPromotionListener();
        toRet.setKeys(new String[]{"partenze"});
        return toRet;
    }
   
    @Bean
    public Step fetchSoluzioniStep(
            StepBuilderFactory stepBuilderFactory, 
            FetchSoluzioniViaggioTasklet fetchSoluzioniViaggioTasklet,
            StepExecutionListener soluzioniViaggioPromotionListener) {
        return stepBuilderFactory.get("fetchSoluzioniStep")
                .tasklet(fetchSoluzioniViaggioTasklet)
                .listener(fetchSoluzioniViaggioTasklet)
                .listener(soluzioniViaggioPromotionListener)
                .build();
    }

    @Bean
    public Step fetchPartenzeStep(
            StepBuilderFactory stepBuilderFactory, 
            FetchPartenzeTasklet fetchPartenzeTasklet,
            StepExecutionListener partenzePromotionListener) {
        return stepBuilderFactory.get("fetchPartenzeStep")
                .tasklet(fetchPartenzeTasklet)
                .listener(fetchPartenzeTasklet)
                .listener(partenzePromotionListener)
                .build();
    }
}
