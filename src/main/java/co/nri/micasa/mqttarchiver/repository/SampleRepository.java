package co.nri.micasa.mqttarchiver.repository;

import co.nri.micasa.mqttarchiver.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long>{
    
}
