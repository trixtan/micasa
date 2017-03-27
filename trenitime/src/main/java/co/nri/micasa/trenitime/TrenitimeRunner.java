package co.nri.micasa.trenitime;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TrenitimeRunner implements ApplicationRunner{
    
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationRunner.class);
    
    @Value("${trenitime.1.fromStation}")
    protected String ttJob1FromStation;
    @Value("${trenitime.1.toStation}")
    protected String ttJob1ToStation;
    @Value("${trenitime.1.minutesToStation}")
    protected Long ttJob1MinutesToStation;
    @Value("${trenitime.1.departure.topic}")
    protected String ttJob1DepartureTopic;
    @Value("${trenitime.1.delay.topic}")
    protected String ttJob1DelayTopic;
    @Value("${trenitime.2.fromStation}")
    protected String ttJob2FromStation;
    @Value("${trenitime.2.toStation}")
    protected String ttJob2ToStation;
    @Value("${trenitime.2.minutesToStation}")
    protected Long ttJob2MinutesToStation;
    @Value("${trenitime.2.departure.topic}")
    protected String ttJob2DepartureTopic;
    @Value("${trenitime.2.delay.topic}")
    protected String ttJob2DelayTopic;
    
    @Autowired
    protected Job trenitimeJob;
    
    @Autowired
    protected JobLauncher jobLauncher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            JobParametersBuilder paramBuilder1 = new JobParametersBuilder();
            paramBuilder1.addDate("timestamp", new Date(), true);
            paramBuilder1.addString("fromStation", ttJob1FromStation);
            paramBuilder1.addString("toStation", ttJob1ToStation);
            paramBuilder1.addLong("minutesToStation", ttJob1MinutesToStation);
            paramBuilder1.addString("departureTopic", ttJob1DepartureTopic);
            paramBuilder1.addString("delayTopic", ttJob1DelayTopic);
            jobLauncher.run(trenitimeJob, paramBuilder1.toJobParameters());

            JobParametersBuilder paramBuilder2 = new JobParametersBuilder();
            paramBuilder2.addDate("timestamp", new Date(), true);
            paramBuilder2.addString("fromStation", ttJob2FromStation);
            paramBuilder2.addString("toStation", ttJob2ToStation);
            paramBuilder1.addLong("minutesToStation", ttJob2MinutesToStation);
            paramBuilder2.addString("departureTopic", ttJob2DepartureTopic);
            paramBuilder2.addString("delayTopic", ttJob2DelayTopic);
            jobLauncher.run(trenitimeJob, paramBuilder2.toJobParameters());
        }
        catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
