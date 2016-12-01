package co.nri.micasa;

import java.util.HashMap;
import java.util.Map;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduleConfiguration  {
    
    @Autowired
    protected Job etraJob;
    
    @Value("${trenitime.1.fromStation}")
    protected String ttJob1FromStation;
    @Value("${trenitime.1.toStation}")
    protected String ttJob1ToStation;
    @Value("${trenitime.1.topic}")
    protected String ttJob1Topic;
    @Value("${trenitime.2.fromStation}")
    protected String ttJob2FromStation;
    @Value("${trenitime.2.toStation}")
    protected String ttJob2ToStation;
    @Value("${trenitime.2.topic}")
    protected String ttJob2Topic;
    
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
    public void getNextTrains() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        Map<String, JobParameter> params1 = new HashMap<>();
        params1.put("fromStation", new JobParameter(this.ttJob1FromStation));
        params1.put("toStation", new JobParameter(this.ttJob1ToStation));
        params1.put("topic", new JobParameter(this.ttJob1Topic));
        
        Map<String, JobParameter> params2 = new HashMap<>();
        params2.put("fromStation", new JobParameter(this.ttJob2FromStation));
        params2.put("toStation", new JobParameter(this.ttJob2ToStation));
        params2.put("topic", new JobParameter(this.ttJob2Topic));
        
        jobLauncher.run(trenitimeJob, new JobParameters(params1));
        jobLauncher.run(trenitimeJob, new JobParameters(params2));
    }

}