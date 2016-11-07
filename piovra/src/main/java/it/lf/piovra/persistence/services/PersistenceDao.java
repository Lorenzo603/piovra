package it.lf.piovra.persistence.services;

import it.lf.piovra.models.Experiment;

public interface PersistenceDao {

    Experiment getExperimentById(String experimentId);

    void persistExperiment(Experiment experiment);

}
