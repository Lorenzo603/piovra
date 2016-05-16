package it.lf.piovra.facades;

import it.lf.piovra.views.FactorData;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public interface FactorFacade {

    FactorData addFactor(String name);

    FactorData editFactor(String id, String name);

    void removeFactor(String id);

}
