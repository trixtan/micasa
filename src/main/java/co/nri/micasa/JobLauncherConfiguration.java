package co.nri.micasa;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.transaction.PlatformTransactionManager;
=======
>>>>>>> 8f070f84dc2aa28000b26f72b5756131fc4ca1ba

@Configuration
public class JobLauncherConfiguration  {
    
    @Bean
<<<<<<< HEAD
    public PlatformTransactionManager transactionManager() {
=======
    public ResourcelessTransactionManager transactionManager() {
>>>>>>> 8f070f84dc2aa28000b26f72b5756131fc4ca1ba
        return new ResourcelessTransactionManager();
    }
    
    @Bean
<<<<<<< HEAD
    public MapJobRepositoryFactoryBean jobRepositoryFactoryBean(PlatformTransactionManager transactionManager) {
=======
    public MapJobRepositoryFactoryBean jobRepositoryFactoryBean(ResourcelessTransactionManager transactionManager) {
>>>>>>> 8f070f84dc2aa28000b26f72b5756131fc4ca1ba
        MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean = new MapJobRepositoryFactoryBean(transactionManager);
        mapJobRepositoryFactoryBean.setTransactionManager(transactionManager);
        return mapJobRepositoryFactoryBean;
    }

    @Bean
<<<<<<< HEAD
    public JobRepository jobRepository(MapJobRepositoryFactoryBean jobRepositoryFactoryBean) throws Exception {
        return jobRepositoryFactoryBean.getObject();
=======
    public JobRepository jobRepository(MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean) throws Exception {
        return mapJobRepositoryFactoryBean.getObject();
>>>>>>> 8f070f84dc2aa28000b26f72b5756131fc4ca1ba
    }
        
    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepo){
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepo);
        return simpleJobLauncher;
    }

}