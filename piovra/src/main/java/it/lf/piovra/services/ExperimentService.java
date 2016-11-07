package it.lf.piovra.services;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.models.User;

public interface ExperimentService {

    Experiment createExperiment(User user, String name);

    Experiment getExperiment();

    void addFactor(Factor factor);

}
