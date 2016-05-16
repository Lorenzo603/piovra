package it.lf.piovra.services;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;

/**
 * Created by Lfurrer on 04/05/2016.
 */
public interface ExperimentService {

    Experiment getExperiment();

    void addFactor(Factor factor);

}
