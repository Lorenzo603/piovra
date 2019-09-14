package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.FactorService;
import it.lf.piovra.services.LevelService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class LevelServiceImpl implements LevelService {

    @Resource
    private ExperimentService experimentService;
    @Resource
    private FactorService factorService;

    @Override
    public Level getLevelById(Factor factor, String id) {
        List<Level> levels = factor.getLevels();
        if (CollectionUtils.isNotEmpty(levels)) {
            for (Level level : levels) {
                if (id.equals(level.getId())) {
                    return level;
                }
            }
        }
        return null;
    }

    @Override
    public Level createLevel(String experimentId, String factorId, String name) {
        Experiment experiment = experimentService.getExperimentById(experimentId).orElse(null);
        if (experiment == null) {
            return null;
        }
        Factor factor = factorService.getFactorById(experiment, factorId);
        if (factor == null) {
            return null;
        }
        Level level = new Level();
        level.setId(generateUniqueIdentifier());
        level.setName(name);
        factor.addLevel(level);
        experimentService.saveExperiment(experiment);
        return level;
    }

    @Override
    public Level updateLevel(String experimentId, String factorId, String id, String name) {
        Experiment experiment = experimentService.getExperimentById(experimentId).orElse(null);
        if (experiment == null) {
            return null;
        }
        Factor factor = factorService.getFactorById(experiment, factorId);
        if (factor == null) {
            return null;
        }
        Level level = getLevelById(factor, id);
        if (level == null) {
            return null;
        }
        level.setName(name);
        experimentService.saveExperiment(experiment);
        return level;
    }

    @Override
    public void removeLevel(String experimentId, String factorId, String id) {
        Experiment experiment = experimentService.getExperimentById(experimentId).orElse(null);
        if (experiment == null) {
            return;
        }
        Factor factor = factorService.getFactorById(experiment, factorId);
        if (factor == null) {
            return;
        }
        Level levelToRemove = getLevelById(factor, id);
        if (levelToRemove == null) {
            return;
        }
        factor.removeLevel(levelToRemove);
        experimentService.saveExperiment(experiment);
    }

    protected String generateUniqueIdentifier() {
        return UUID.randomUUID().toString();
    }

}
