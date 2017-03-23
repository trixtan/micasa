package co.nri.micasa.mqttarchiver.service;

import java.util.Date;

public interface SampleService {
    
    void saveSample(String topic, String data, Date timestamp);
}
