package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.FactorFacade;
import it.lf.piovra.models.Factor;
import it.lf.piovra.services.FactorConverter;
import it.lf.piovra.services.FactorService;
import it.lf.piovra.views.FactorData;

import javax.annotation.Resource;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public class FactorFacadeImpl implements FactorFacade {

    @Resource
    private FactorService factorService;
    @Resource
    private FactorConverter factorConverter;

    @Override
    public FactorData createFactor(String name) {
        Factor factor = factorService.createFactor(name);
        return factorConverter.convert(factor);
    }
}
