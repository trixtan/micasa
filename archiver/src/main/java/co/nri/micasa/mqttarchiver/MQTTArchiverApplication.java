package co.nri.micasa.mqttarchiver;

import co.nri.micasa.mqttarchiver.service.SampleService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@SpringBootApplication
@EnableAutoConfiguration
@IntegrationComponentScan
public class MQTTArchiverApplication {
    
    @Value("${mqttServer}")
    private String broker;
    
    @Value("#{'${mqtt.archiver.subscribedTopics}'.split(',')}")
    private List<String> subscribedTopics;
    
    @Autowired
    private SampleService sampleService;
    
    
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = new SpringApplication(MQTTArchiverApplication.class).run(args);
        System.out.println("Hit Enter to terminate");
        System.in.read();
        ctx.close();
    }
    
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }
    
    @Bean
    public MessageProducer inbound() {
    	   MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
                   broker, 
                   "MQTTArchiver", 
                   subscribedTopics.toArray(new String[subscribedTopics.size()]));
    	adapter.setConverter(new DefaultPahoMessageConverter());
    	adapter.setOutputChannel(mqttInputChannel());
    	return adapter;
    }
    
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
    	return (Message<?> message) -> {
            String topic = message.getHeaders().get(MqttHeaders.TOPIC, String.class);
            Long timestamp = message.getHeaders().get("timestamp", Long.class);
            sampleService.saveSample(topic, message.getPayload().toString(), new Date(timestamp));
            };
    }
}

