package it.lf.piovra.facades;

import it.lf.piovra.views.ExperimentData;

public interface ExperimentFacade {

    ExperimentData createExperiment(String name);

    ExperimentData getExperiment();


}
