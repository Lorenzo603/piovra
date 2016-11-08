package it.lf.piovra.facades;

import it.lf.piovra.views.FactorData;


public interface FactorFacade {

    FactorData addFactor(String experimentId, String name);

    FactorData editFactor(String experimentId, String id, String name);

    void removeFactor(String experimentId, String id);

}
