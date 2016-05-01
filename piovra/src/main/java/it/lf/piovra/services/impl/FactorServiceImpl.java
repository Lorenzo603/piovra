package it.lf.piovra.services.impl;

import it.lf.piovra.models.Factor;
import it.lf.piovra.services.FactorService;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public class FactorServiceImpl implements FactorService {

    @Override
    public Factor createFactor(String name) {
        Factor factor = new Factor();
        factor.setName(name);
        return factor;
    }

}
