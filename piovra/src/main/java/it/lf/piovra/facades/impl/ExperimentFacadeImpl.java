package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.ExperimentFacade;
import it.lf.piovra.facades.data.CreateExperimentResult;
import it.lf.piovra.facades.data.CreateExperimentStatus;
import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;
import it.lf.piovra.services.ExperimentConverter;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.UserService;
import it.lf.piovra.views.ExperimentData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExperimentFacadeImpl implements ExperimentFacade {

    @Resource
    private ExperimentService experimentService;
    @Resource
    private ExperimentConverter experimentConverter;
    @Resource
    private UserService userService;

    @Override
    public CreateExperimentResult createExperiment(String name) {
        User user = userService.getCurrentUser();
        if (userService.isAnonymousUser(user)) {
            return null;
        }
        if (experimentService.getExperimentById(name).isPresent()) {
            return new CreateExperimentResult(CreateExperimentStatus.EXPERIMENT_ALREADY_EXISTS, "createExperiment.experiment.already.exists");
        }
        return new CreateExperimentResult(experimentConverter.convert(experimentService.createExperiment(user, name)));
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
        return experimentConverter.convert(experimentService.getExperimentById(id).get());
    }

}
