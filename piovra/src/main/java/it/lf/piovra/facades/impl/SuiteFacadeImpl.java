package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.SuiteFacade;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.SuiteService;
import it.lf.piovra.views.SuiteData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * Created by Lfurrer on 28/04/2016.
 */
public class SuiteFacadeImpl implements SuiteFacade {

    private SuiteService suiteService;

    private ExperimentService experimentService;

    @Override
    public SuiteData calculate() {
        SuiteData suiteData = new SuiteData();
        List<List<String>> results = suiteService.calculate(experimentService.getExperiment());
        suiteData.setCases(results);
        return suiteData;
    }

    @Required
    public void setSuiteService(SuiteService suiteService) {
        this.suiteService = suiteService;
    }

    @Required
    public void setExperimentService(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }
}
