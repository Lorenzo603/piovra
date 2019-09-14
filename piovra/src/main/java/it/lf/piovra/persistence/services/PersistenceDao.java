package it.lf.piovra.persistence.services;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;

import java.util.List;
import java.util.Optional;


public interface PersistenceDao {

    Optional<Experiment> getExperimentById(String experimentId);

    List<Experiment> getExperimentsByUser(User user);

    Optional<User> getUserByEmail(String email);

    void persistExperiment(Experiment experiment);

    void persistUser(User user);

}
