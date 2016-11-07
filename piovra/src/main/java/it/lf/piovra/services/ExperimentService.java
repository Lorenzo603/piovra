package it.lf.piovra.services;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.models.User;

import java.util.List;

public interface ExperimentService {

    Experiment createExperiment(User user, String name);

    Experiment getExperiment();

    List<Experiment> getExperimentsByUser(User user);

    void addFactor(Factor factor);

}
