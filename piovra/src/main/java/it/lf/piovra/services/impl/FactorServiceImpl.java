package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
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
    public Factor createFactor(String experimentId, String name) {
        Experiment experiment = experimentService.getExperimentById(experimentId);
        if (experiment == null) {
            return null;
        }
        Factor factor = new Factor();
        factor.setId(generateUniqueIdentifier());
        factor.setName(name);
        experiment.addFactor(factor);
        experimentService.saveExperiment(experiment);
        return factor;
    }

    @Override
    public Factor updateFactor(String experimentId, String id, String name) {
        Experiment experiment = experimentService.getExperimentById(experimentId);
        if (experiment == null) {
            return null;
        }
        Factor factor = getFactorById(experiment, id);
        factor.setName(name);
        experimentService.saveExperiment(experiment);
        return factor;
    }

    @Override
    public Factor getFactorById(Experiment experiment, String id) {
        List<Factor> factors = experiment.getFactors();
        if (CollectionUtils.isNotEmpty(factors)) {
            for (Factor factor : factors) {
                if (id.equals(factor.getId())) {
                    return factor;
                }
            }
        }
        return null;
    }

    @Override
    public void removeFactor(String experimentId, String id) {
        Experiment experiment = experimentService.getExperimentById(experimentId);
        if (experiment == null) {
            return;
        }
        Factor factorToRemove = getFactorById(experiment, id);
        factorToRemove.clearLevels();
        experiment.removeFactor(factorToRemove);
        experimentService.saveExperiment(experiment);
    }

    protected String generateUniqueIdentifier() {
        return UUID.randomUUID().toString();
    }

}
