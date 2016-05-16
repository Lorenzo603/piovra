package it.lf.piovra.services;

import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public interface FactorService {

    Factor getFactorById(String id);

    Factor createFactor(String name);

    void addLevel(Level level, String factorId);
    void addLevel(Level level, Factor factor);

}
