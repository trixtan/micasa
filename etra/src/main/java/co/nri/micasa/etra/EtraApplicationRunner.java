package co.nri.micasa.etra;

import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EtraApplicationRunner implements ApplicationRunner {
    
    @Autowired
    protected Job etraJob;
    
    @Autowired
    protected JobLauncher jobLauncher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JobParametersBuilder paramBuilder = new JobParametersBuilder();
        paramBuilder.addDate("timestamp", new Date(), true);
        jobLauncher.run(etraJob, paramBuilder.toJobParameters());
    }
}

