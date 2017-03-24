package co.nri.micasa.etra;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableAutoConfiguration
@EnableScheduling
public class EtraApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EtraApplication.class, args);
    }
}

