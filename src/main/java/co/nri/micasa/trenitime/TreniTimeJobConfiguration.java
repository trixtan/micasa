package co.nri.micasa.trenitime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import co.nri.micasa.trenitime.model.in.viaggiatreno.partenze.PartenzaIn;
import co.nri.micasa.trenitime.model.out.partenze.Partenza;
import co.nri.micasa.trenitime.processor.PartenzaProcessor;
import co.nri.micasa.trenitime.reader.SoluzioniViaggioNewReader;
import co.nri.micasa.trenitime.tasklet.FetchPartenzeTasklet;
import co.nri.micasa.trenitime.tasklet.FetchSoluzioniViaggioTasklet;

@Configuration
@EnableBatchProcessing
public class TreniTimeJobConfiguration {

    @Bean
    public ItemReader<PartenzaIn> reader() {
        return new SoluzioniViaggioNewReader();
    }

    @Bean
    public ItemProcessor<PartenzaIn, Partenza> processor() {
        return new PartenzaProcessor();
    }

    @Bean
    public ItemWriter<Partenza> writer() {
        FlatFileItemWriter writer = new FlatFileItemWriter<Partenza>();
        writer.setLineAggregator((item) -> item.toString());
        writer.setResource(new FileSystemResource("C:\\dev\\TreniTime"));
        return writer;
    }

    @Bean
    public Job fetchPartenzeJob(
            JobBuilderFactory jobs,
            Step fetchSoluzioniStep,
            Step fetchPartenzeStep,
            JobExecutionListener listener) {
        return jobs.get("fetchPartenzeJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(fetchSoluzioniStep)
                .next(fetchPartenzeStep)
                .end()
                .build();
    }

    @Bean
    public Step fetchSoluzioniStep(StepBuilderFactory stepBuilderFactory, FetchSoluzioniViaggioTasklet fetchSoluzioniViaggioTasklet) {
        return stepBuilderFactory.get("fetchSoluzioniStep")
                .tasklet(fetchSoluzioniViaggioTasklet)
                .build();
    }

    @Bean
    public Step fetchPartenzeStep(StepBuilderFactory stepBuilderFactory, FetchPartenzeTasklet fetchPartenzeTasklet) {
        return stepBuilderFactory.get("fetchPartenzeStep")
                .tasklet(fetchPartenzeTasklet)
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<PartenzaIn> reader,
                      ItemWriter<Partenza> writer, ItemProcessor<PartenzaIn, Partenza> processor) {
        return stepBuilderFactory.get("step1")
                .<PartenzaIn, Partenza> chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
