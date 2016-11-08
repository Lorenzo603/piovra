package it.lf.piovra.services;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;

import java.util.List;

public interface ExperimentService {

    Experiment createExperiment(User user, String name);

    Experiment getExperimentById(String id);

    List<Experiment> getExperimentsByUser(User user);

    void saveExperiment(Experiment experiment);

}
