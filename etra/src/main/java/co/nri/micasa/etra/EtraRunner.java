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
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EtraRunner implements ApplicationRunner {
    
    private static final Logger LOG = LoggerFactory.getLogger(EtraRunner.class);
    
    @Autowired
    protected Job etraJob;
    
    @Autowired
    protected JobLauncher jobLauncher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JobParametersBuilder paramBuilder = new JobParametersBuilder();
        paramBuilder.addDate("timestamp", new Date(), true);
        
        try {
            jobLauncher.run(etraJob, paramBuilder.toJobParameters());
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            LOG.error(e.getMessage(), e);
        } 
    }

}

