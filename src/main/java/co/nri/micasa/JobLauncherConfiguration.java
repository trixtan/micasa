package co.nri.micasa;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JobLauncherConfiguration  {
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }
    
    @Bean
    public MapJobRepositoryFactoryBean jobRepositoryFactoryBean(PlatformTransactionManager transactionManager) {
        MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean = new MapJobRepositoryFactoryBean(transactionManager);
        mapJobRepositoryFactoryBean.setTransactionManager(transactionManager);
        return mapJobRepositoryFactoryBean;
    }

    @Bean
    public JobRepository jobRepository(MapJobRepositoryFactoryBean jobRepositoryFactoryBean) throws Exception {
        return jobRepositoryFactoryBean.getObject();
    }
        
    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepo){
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepo);
        return simpleJobLauncher;
    }

}