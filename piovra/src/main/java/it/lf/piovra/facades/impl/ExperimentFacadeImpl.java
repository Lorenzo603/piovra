package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.ExperimentFacade;
import it.lf.piovra.models.User;
import it.lf.piovra.services.ExperimentConverter;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.UserService;
import it.lf.piovra.views.ExperimentData;

import javax.annotation.Resource;


public class ExperimentFacadeImpl implements ExperimentFacade {

    @Resource
    private ExperimentService experimentService;
    @Resource
    private ExperimentConverter experimentConverter;
    @Resource
    private UserService userService;

    @Override
    public ExperimentData createExperiment(String name) {
        User user = userService.getCurrentUser();
        if (userService.isAnonymousUser(user)) {
            return null;
        }
        return experimentConverter.convert(experimentService.createExperiment(user, name));
    }

    @Override
    public ExperimentData getExperiment() {
        return experimentConverter.convert(experimentService.getExperiment());
    }

}
