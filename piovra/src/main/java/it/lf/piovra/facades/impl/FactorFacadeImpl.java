package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.FactorFacade;
import it.lf.piovra.models.Factor;
import it.lf.piovra.services.FactorConverter;
import it.lf.piovra.services.FactorService;
import it.lf.piovra.views.FactorData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FactorFacadeImpl implements FactorFacade {

    @Resource
    private FactorService factorService;
    @Resource
    private FactorConverter factorConverter;

    @Override
    public FactorData addFactor(String experimentId, String name) {
        Factor factor = factorService.createFactor(experimentId, name);
        if (factor == null) {
            return null;
        }
        return factorConverter.convert(factor);
    }

    @Override
    public FactorData editFactor(String experimentId, String id, String name) {
        Factor factor = factorService.updateFactor(experimentId, id, name);
        return factorConverter.convert(factor);
    }

    @Override
    public void removeFactor(String experimentId, String id) {
        factorService.removeFactor(experimentId, id);
    }

}
