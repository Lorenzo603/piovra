package it.lf.piovra.persistence.repository;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExperimentRepository extends MongoRepository<Experiment, String> {

    List<Experiment> findByUser(User user);

}
