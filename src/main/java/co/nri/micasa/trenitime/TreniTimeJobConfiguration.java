package co.nri.micasa.trenitime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;

import co.nri.micasa.trenitime.tasklet.FetchPartenzeTasklet;
import co.nri.micasa.trenitime.tasklet.FetchSoluzioniViaggioTasklet;
import co.nri.micasa.trenitime.tasklet.TrenitimePublishTasklet;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.stereotype.Component;

@Component
public class TreniTimeJobConfiguration {

    @Bean
    public Job trenitimeJob(
            JobBuilderFactory jobs,
            Step fetchSoluzioniStep,
            Step fetchPartenzeStep,
            Step publishNextTrainStep) {
        return jobs.get("fetchPartenzeJob")
                .incrementer(new RunIdIncrementer())
                .start(fetchSoluzioniStep)
                .next(fetchPartenzeStep)
                .next(publishNextTrainStep)
                .build();
    }

    @Bean
    public StepExecutionListener soluzioniViaggioPromotionListener() {
        ExecutionContextPromotionListener toRet = new ExecutionContextPromotionListener();
        toRet.setKeys(new String[]{"soluzioniViaggio"});
        return toRet;
    }
    
    @Bean
    public StepExecutionListener partenzePromotionListener() {
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
    
    @Bean
    public Step publishNextTrainStep(
            StepBuilderFactory stepBuilderFactory, 
            TrenitimePublishTasklet trenitimePublishTasklet) {
        return stepBuilderFactory.get("publishPartenzeStep")
                .tasklet(trenitimePublishTasklet)
                .listener(trenitimePublishTasklet)
                .build();
    }
}
