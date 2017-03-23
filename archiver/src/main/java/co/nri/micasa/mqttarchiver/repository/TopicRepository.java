package co.nri.micasa.mqttarchiver.repository;

import co.nri.micasa.mqttarchiver.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    
    Topic findByName(String name);
}
