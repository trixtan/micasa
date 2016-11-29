package co.nri.micasa.etra;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableBatchProcessing
@EnableAutoConfiguration
public class EtraBatchConfiguration {
    
    enum TRASH_TYPE {
        UMIDO,
        SECCO,
        VERDE_E_RAMAGLIE,
        PLASTICA,
        VETRO,
        CARTA_E_CARTONE;
                
        public static TRASH_TYPE fromDescription(String description) {
            switch(description){
                case "Umido":
                    return UMIDO;
                case "Secco":
                    return SECCO;
                case "Verde e ramaglie":
                    return VERDE_E_RAMAGLIE;
                case "Plastica":
                    return PLASTICA;
                case "Vetro":
                    return VETRO;
                case "Carta e cartone":
                    return CARTA_E_CARTONE;
                default:
                    return null;
            }
        }
    };

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