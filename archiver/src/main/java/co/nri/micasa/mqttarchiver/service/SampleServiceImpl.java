package co.nri.micasa.mqttarchiver.service;

import co.nri.micasa.mqttarchiver.model.Sample;
import co.nri.micasa.mqttarchiver.model.Topic;
import co.nri.micasa.mqttarchiver.repository.SampleRepository;
import co.nri.micasa.mqttarchiver.repository.TopicRepository;
import java.util.Date;
import javax.transaction.Transactional;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {
    
    @Autowired
    private TopicRepository topicRepository;
    
    @Autowired
    private SampleRepository sampleRepository;
    
    @Override
    @Transactional
    public void saveSample(String topic, String data, Date timestamp) {
        Validate.notEmpty(topic);
        Validate.notEmpty(data);
        Validate.notNull(timestamp);
        
        Topic t = this.topicRepository.findByName(topic);
        
        if(t == null) {
            t = new Topic();
            t.setName(topic);
            t = this.topicRepository.save(t);
        }
        
        Sample sample = new Sample();
        sample.setTopic(t);
        sample.setData(data);
        sample.setCreated(timestamp);
        
        this.sampleRepository.save(sample);
    }
    
    
}
