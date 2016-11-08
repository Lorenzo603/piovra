package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;
import it.lf.piovra.persistence.services.PersistenceDao;
import it.lf.piovra.services.ExperimentService;

import javax.annotation.Resource;
import java.util.List;

public class ExperimentServiceImpl implements ExperimentService {

    @Resource
    private PersistenceDao persistenceDao;

    @Override
    public Experiment createExperiment(User user, String name) {
        Experiment experiment = new Experiment();
        experiment.setName(name);
        experiment.setUser(user);
        experiment.setId(calculateExperimentId(experiment));
        persistenceDao.persistExperiment(experiment);
        return experiment;
    }

    private String calculateExperimentId(Experiment experiment) {
        return experiment.getUser().getEmail() + "_" + experiment.getName();
    }

    @Override
    public Experiment getExperimentById(String id) {
        return persistenceDao.getExperimentById(id);
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
