package it.lf.piovra.persistence.repository;

import it.lf.piovra.models.Experiment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExperimentRepository extends MongoRepository<Experiment, String> {


}
