package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.services.ExperimentService;

/**
 * Created by Lfurrer on 04/05/2016.
 */
public class ExperimentServiceImpl implements ExperimentService {

    private Experiment THE_ONE = new Experiment();

    @Override
    public Experiment getExperiment() {
        return THE_ONE;
    }

}
