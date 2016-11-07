package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.User;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.persistence.services.PersistenceDao;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;

public class ExperimentServiceImpl implements ExperimentService {

    private Experiment THE_ONE = new Experiment();

    @Resource
    private PersistenceDao persistenceDao;

    @Override
    public Experiment createExperiment(User user, String name) {
        Experiment experiment = new Experiment();
        experiment.setName(name);
        experiment.setUser(user);
        experiment.setId(getExperimentId(experiment));
        persistenceDao.persistExperiment(experiment);
        return experiment;
    }

    private String getExperimentId(Experiment experiment) {
        return experiment.getUser().getEmail() + "_" + experiment.getName();
    }

    @Override
    public Experiment getExperiment() {
        return THE_ONE;
    }


    @Override
    public void addFactor(Factor factor) {
        THE_ONE.addFactor(factor);
    }

}
