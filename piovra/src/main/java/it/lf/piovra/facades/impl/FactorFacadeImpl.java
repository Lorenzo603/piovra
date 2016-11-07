package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.FactorFacade;
import it.lf.piovra.models.Factor;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.FactorConverter;
import it.lf.piovra.services.FactorService;
import it.lf.piovra.views.FactorData;

import javax.annotation.Resource;


public class FactorFacadeImpl implements FactorFacade {

    @Resource
    private FactorService factorService;
    @Resource
    private FactorConverter factorConverter;
    @Resource
    private ExperimentService experimentService;


    @Override
    public FactorData addFactor(String name) {
        Factor factor = factorService.createFactor(name);
        experimentService.addFactor(factor);
        return factorConverter.convert(factor);
    }

    @Override
    public FactorData editFactor(String id, String name) {
        Factor factor = factorService.getFactorById(id);
        factor.setName(name);
        return factorConverter.convert(factor);
    }

    @Override
    public void removeFactor(String id) {
        factorService.removeFactor(id);
    }

}
