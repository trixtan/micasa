package co.nri.micasa.etra;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
@EnableAutoConfiguration
public class EtraApplication {

    public static void main(String[] args) throws Exception {
        System.exit(SpringApplication.exit(SpringApplication.run(EtraApplication.class, args)));
    }
}

