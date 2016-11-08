package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;
import it.lf.piovra.persistence.services.PersistenceDao;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.UserService;

import javax.annotation.Resource;
import java.util.List;

public class ExperimentServiceImpl implements ExperimentService {

    @Resource
    private PersistenceDao persistenceDao;
    @Resource
    private UserService userService;

    @Override
    public Experiment createExperiment(User user, String name) {
        Experiment experiment = new Experiment();
        experiment.setName(name);
        experiment.setUser(user);
        experiment.setId(calculateExperimentId(user, name));
        persistenceDao.persistExperiment(experiment);
        return experiment;
    }

    private String calculateExperimentId(User user, String id) {
        return user.getEmail() + "_" + id;
    }

    @Override
    public Experiment getExperimentById(String id) {
        User user = userService.getCurrentUser();
        return persistenceDao.getExperimentById(calculateExperimentId(user, id));
    }

    @Override
    public List<Experiment> getExperimentsByUser(User user) {
        return persistenceDao.getExperimentsByUser(user);
    }

    @Override
    public void saveExperiment(Experiment experiment) {
        persistenceDao.persistExperiment(experiment);
    }

}
