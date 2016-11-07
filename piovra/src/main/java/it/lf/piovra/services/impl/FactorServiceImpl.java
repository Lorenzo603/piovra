package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.FactorService;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

public class FactorServiceImpl implements FactorService {

    @Resource
    private ExperimentService experimentService;

    @Override
    public Factor getFactorById(String id) {
        Experiment experiment = experimentService.getExperiment();
        List<Factor> factors = experiment.getFactors();
        if (CollectionUtils.isNotEmpty(factors)) {
            for (Factor factor : factors) {
                if (id.equals(factor.getId())) {
                    return factor;
                }
            }
        }
        throw new IllegalStateException("Factor with id '" + id + "' not found.");
    }

    @Override
    public Factor createFactor(String name) {
        Factor factor = new Factor();
        factor.setId(generateUniqueIdentifier());
        factor.setName(name);
        return factor;
    }

    @Override
    public void removeFactor(String id) {
        Factor factorToRemove = getFactorById(id);
        factorToRemove.clearLevels();
        experimentService.getExperiment().removeFactor(factorToRemove);
    }

    @Override
    public void addLevel(Level level, String factorId) {
        addLevel(level, getFactorById(factorId));
    }

    @Override
    public void addLevel(Level level, Factor factor) {
        factor.addLevel(level);
    }

    protected String generateUniqueIdentifier() {
        return UUID.randomUUID().toString();
    }

}
