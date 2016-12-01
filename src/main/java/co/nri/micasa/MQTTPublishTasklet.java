package co.nri.micasa;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

public abstract class MQTTPublishTasklet implements Tasklet {
    
    private static final Logger LOG = LoggerFactory.getLogger(MQTTPublishTasklet.class);

    @Value("${mqttServer}")
    protected String broker;

    protected abstract String getClientId();

    protected void publish(String topic, String content) {
        if(StringUtils.isEmpty(topic)) return;
        if(StringUtils.isEmpty(content)) return;
        
        MemoryPersistence persistence = new MemoryPersistence();
        
        try {
            MqttClient sampleClient = new MqttClient(broker, getClientId(), persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            sampleClient.connect(connOpts);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(2);
            message.setRetained(true);
            sampleClient.publish(topic, message);
            
            sampleClient.disconnect();
        } catch (MqttException me) {
            LOG.error(me.getMessage(), me);
            me.printStackTrace();
        }
    }
    /*
    protected void publish(String topic, String content) {
        System.out.println(topic + content);
    }
*/
}
