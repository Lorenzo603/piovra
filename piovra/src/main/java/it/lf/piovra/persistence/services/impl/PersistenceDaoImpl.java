package it.lf.piovra.persistence.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.User;
import it.lf.piovra.persistence.repository.ExperimentRepository;
import it.lf.piovra.persistence.repository.UserRepository;
import it.lf.piovra.persistence.services.PersistenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersistenceDaoImpl implements PersistenceDao {

    @Autowired
    private ExperimentRepository experimentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Experiment> getExperimentById(String experimentId) {
        return experimentRepository.findById(experimentId);
    }

    @Override
    public List<Experiment> getExperimentsByUser(User user) {
        return experimentRepository.findByUser(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findById(email);
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
