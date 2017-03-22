package co.nri.micasa.mqttarchiver.model;

import co.nri.micasa.common.model.AbstractEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sample extends AbstractEntity {
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;
    
    @Column(name = "data")
    private String data;
    
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
