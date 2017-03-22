package co.nri.micasa.mqttarchiver.model;

import co.nri.micasa.common.model.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Topic extends AbstractEntity {
    
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
