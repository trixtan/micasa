package co.nri.micasa;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduleConfiguration {
    
    @Autowired
    protected Job etraJob;
    
    @Autowired
    protected Job trenitimeJob;
    
    @Autowired
    protected JobLauncher jobLauncher;
    
    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepo){
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepo);
        return simpleJobLauncher;
    }
    
    @Scheduled(cron = "0 0 1 * * *")
    public void reportCurrentTime() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        jobLauncher.run(etraJob, new JobParameters());
    }
    
    //Every five minutes
    @Scheduled(fixedRate = 300000)
    public void getNextTrainToMestre() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        jobLauncher.run(trenitimeJob, new JobParameters());
    }

}