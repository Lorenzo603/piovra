package it.lf.piovra.services;

import it.lf.piovra.models.Experiment;

/**
 * Created by lfurrer on 27/10/2016.
 */
public interface PersistenceDao {

    Experiment getExperimentById(String experimentId);

}
