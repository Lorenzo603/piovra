package it.lf.piovra.services;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;


public interface FactorService {

    Factor createFactor(String experimentId, String name);

    Factor getFactorById(Experiment experiment, String id);

    Factor updateFactor(String experimentId, String id, String name);

    void removeFactor(String experimentId, String id);

}
