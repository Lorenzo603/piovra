package it.lf.piovra.persistence.services;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;

import java.util.List;

public interface PersistenceDao {

    Experiment getExperimentById(String experimentId);

    List<Experiment> getExperimentsByUser(User user);

    User getUserByEmail(String email);

    void persistExperiment(Experiment experiment);

    void persistUser(User user);

}
