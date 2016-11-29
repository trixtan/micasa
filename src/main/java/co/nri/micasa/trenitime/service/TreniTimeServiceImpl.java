package co.nri.micasa.trenitime.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.nri.micasa.trenitime.model.out.partenze.Partenza;

@Component
public class TreniTimeServiceImpl implements TreniTimeService {

    private String topic = "timetables/trains";

    @Value("${trenitime.timetableSize}")
    private Integer timetableSize;

    @Value("${mqtt.trenitime.broker}")
    private String broker;

    @Value("${mqtt.trenitime.clientId}")
    private String clientId;

    @Override
    public void publishPartenze(Partenza... partenze) throws MqttException {
        MqttClient mqttClient = new MqttClient(this.broker, this.clientId, new MemoryPersistence());
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        mqttClient.connect(connOpts);

        Partenza partenza = null;
        for(int i=0; i<timetableSize; i++) {
            if(partenze != null && partenze.length > i) {
                partenza = partenze[i];
            }
            if(partenza != null) {
                publishPartenza(i, partenza, mqttClient);
            } else {
                clearPartenza(i, mqttClient);
            }
        }

        mqttClient.disconnect();
    }

    private void publishPartenza(int position, Partenza partenza, MqttClient mqttClient) {
        StringBuilder sb = new StringBuilder(partenza.getCategoriaTreno())
                .append("|").append(Long.toString(partenza.getOrarioPartenza()));
        MqttMessage message = new MqttMessage();
        message.setQos(2);
        message.setPayload(sb.toString().getBytes());
        mqttClient.publish(topic + "/" + position, message);
    }

    private void clearPartenza(int position, MqttClient mqttClient) {
        mqttClient.publish(topic + "/" + position, null);
    }

}
