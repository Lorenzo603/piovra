package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.ExperimentFacade;
import it.lf.piovra.models.Experiment;
import it.lf.piovra.services.ExperimentConverter;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.views.ExperimentData;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by Lfurrer on 04/05/2016.
 */
public class ExperimentFacadeImpl implements ExperimentFacade {

    private ExperimentService experimentService;
    private ExperimentConverter experimentConverter;

    @Override
    public ExperimentData getExperiment() {
        return experimentConverter.convert(experimentService.getExperiment());
    }

    @Required
    public void setExperimentService(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @Required
    public void setExperimentConverter(ExperimentConverter experimentConverter) {
        this.experimentConverter = experimentConverter;
    }
}
