package it.lf.piovra.facades;

import it.lf.piovra.views.ExperimentData;

import java.util.List;

public interface ExperimentFacade {

    ExperimentData createExperiment(String name);

    List<ExperimentData> getExperimentsByCurrentUser();

    ExperimentData getExperimentById(String id);


}
