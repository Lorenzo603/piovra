package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.ExperimentFacade;
import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;
import it.lf.piovra.services.ExperimentConverter;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.UserService;
import it.lf.piovra.views.ExperimentData;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


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
    public List<ExperimentData> getExperimentsByCurrentUser() {
        User user = userService.getCurrentUser();
        if (userService.isAnonymousUser(user)) {
            return new ArrayList<>();
        }
        List<Experiment> experiments = experimentService.getExperimentsByUser(user);
        List<ExperimentData> experimentsData = new ArrayList<>();
        for (Experiment experiment : experiments) {
            experimentsData.add(experimentConverter.convert(experiment));
        }
        return experimentsData;
    }

    @Override
    public ExperimentData getExperimentById(String id) {
        return experimentConverter.convert(experimentService.getExperimentById(id));
    }

}
