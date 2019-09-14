package it.lf.piovra.services;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;

import java.util.List;
import java.util.Optional;


public interface ExperimentService {

    Experiment createExperiment(User user, String name);

    Optional<Experiment> getExperimentById(String id);

    List<Experiment> getExperimentsByUser(User user);

    void saveExperiment(Experiment experiment);

}
