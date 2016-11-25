package it.lf.piovra.facades;

import it.lf.piovra.facades.data.CreateExperimentResult;
import it.lf.piovra.views.ExperimentData;

import java.util.List;

public interface ExperimentFacade {

    CreateExperimentResult createExperiment(String name);

    List<ExperimentData> getExperimentsByCurrentUser();

    ExperimentData getExperimentById(String id);


}
