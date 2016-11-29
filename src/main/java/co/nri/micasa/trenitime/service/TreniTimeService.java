package co.nri.micasa.trenitime.service;

import org.eclipse.paho.client.mqttv3.MqttException;

import co.nri.micasa.trenitime.model.out.partenze.Partenza;

public interface TreniTimeService {

    void publishPartenze(Partenza ... partenze) throws MqttException;

}
