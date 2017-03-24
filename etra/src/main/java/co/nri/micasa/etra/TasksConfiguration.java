package co.nri.micasa.etra;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TasksConfiguration{
    
    private static final Logger LOG = LoggerFactory.getLogger(TasksConfiguration.class);
    
    @Autowired
    protected Job etraJob;
    
    @Autowired
    protected JobLauncher jobLauncher;

    @Scheduled(cron = "${etra.cron}")
    public void run() {
        JobParametersBuilder paramBuilder = new JobParametersBuilder();
        paramBuilder.addDate("timestamp", new Date(), true);
        
        try {
            jobLauncher.run(etraJob, paramBuilder.toJobParameters());
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            LOG.error(e.getMessage(), e);
        } 
    }
}

