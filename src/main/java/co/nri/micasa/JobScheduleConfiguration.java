package co.nri.micasa;

import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduleConfiguration  {
    
    @Value("${trenitime.1.fromStation}")
    protected String ttJob1FromStation;
    @Value("${trenitime.1.toStation}")
    protected String ttJob1ToStation;
    @Value("${trenitime.1.departure.topic}")
    protected String ttJob1DepartureTopic;
    @Value("${trenitime.1.delay.topic}")
    protected String ttJob1DelayTopic;
    @Value("${trenitime.2.fromStation}")
    protected String ttJob2FromStation;
    @Value("${trenitime.2.toStation}")
    protected String ttJob2ToStation;
    @Value("${trenitime.2.departure.topic}")
    protected String ttJob2DepartureTopic;
    @Value("${trenitime.2.delay.topic}")
    protected String ttJob2DelayTopic;    
    
    @Autowired
    protected Job trenitimeJob;
    
    @Autowired
    protected Job timeJob;
    
    @Autowired
    protected Job etraJob;
    
    @Autowired
    protected JobLauncher jobLauncher;
    
    @Autowired
    protected MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean;
   
    //Every minute, remove data from mapJobRepository. Prevent heap space exception
    @Scheduled(cron = "0 * * * * * *")
    public void clearInMemoryJobRepository() {
        mapJobRepositoryFactoryBean.clear();
    }
    
    @Scheduled(cron = "${time.cron}")
    public void reportCurrentTime() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        JobParametersBuilder paramBuilder = new JobParametersBuilder();
        paramBuilder.addDate("timestamp", new Date(), true);
        jobLauncher.run(timeJob, paramBuilder.toJobParameters());
    }
    
    @Scheduled(cron = "${etra.cron}")
    public void getEtraForTomorrow() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        JobParametersBuilder paramBuilder = new JobParametersBuilder();
        paramBuilder.addDate("timestamp", new Date(), true);
        jobLauncher.run(etraJob, paramBuilder.toJobParameters());
    }
    
    @Scheduled(cron = "${trenitime.cron}")
    public void getNextTrains() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        JobParametersBuilder paramBuilder1 = new JobParametersBuilder();
        paramBuilder1.addString("fromStation", this.ttJob1FromStation);
        paramBuilder1.addString("toStation", this.ttJob1ToStation);
        paramBuilder1.addString("departureTopic", this.ttJob1DepartureTopic);
        paramBuilder1.addString("delayTopic", this.ttJob1DelayTopic);
        paramBuilder1.addDate("timestamp", new Date(), true);
        
        JobParametersBuilder paramBuilder2 = new JobParametersBuilder();
        paramBuilder2.addString("fromStation", this.ttJob2FromStation);
        paramBuilder2.addString("toStation", this.ttJob2ToStation);
        paramBuilder2.addString("departureTopic", this.ttJob2DepartureTopic);
        paramBuilder2.addString("delayTopic", this.ttJob2DelayTopic);
        paramBuilder2.addDate("timestamp", new Date(), true);
        
        
        jobLauncher.run(trenitimeJob, paramBuilder1.toJobParameters());
        jobLauncher.run(trenitimeJob, paramBuilder2.toJobParameters());
    }

}
