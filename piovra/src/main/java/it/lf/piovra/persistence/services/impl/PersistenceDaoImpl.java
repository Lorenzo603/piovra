package it.lf.piovra.persistence.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;
import it.lf.piovra.persistence.repository.ExperimentRepository;
import it.lf.piovra.persistence.repository.UserRepository;
import it.lf.piovra.persistence.services.PersistenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.List;

public class PersistenceDaoImpl implements PersistenceDao {

    @Autowired
    private ExperimentRepository experimentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Experiment getExperimentById(String experimentId) {
        return experimentRepository.findOne(experimentId);
    }

    @Override
    public List<Experiment> getExperimentsByUser(User user) {
        Experiment experimentExample = new Experiment();
        experimentExample.setUser(user);
        return experimentRepository.findAll(Example.of(experimentExample));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findOne(email);
    }

    @Override
    public void persistExperiment(Experiment experiment) {
        experimentRepository.save(experiment);
    }

    @Override
    public void persistUser(User user) {
        userRepository.save(user);
    }

}
