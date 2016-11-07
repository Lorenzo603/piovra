package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.LevelService;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

public class LevelServiceImpl implements LevelService {

    @Resource
    private ExperimentService experimentService;

    @Override
    public Level getLevelById(String id) {
        Experiment experiment = experimentService.getExperiment();
        List<Factor> factors = experiment.getFactors();
        if (CollectionUtils.isNotEmpty(factors)) {
            for (Factor factor : factors) {
                List<Level> levels = factor.getLevels();
                if (CollectionUtils.isNotEmpty(levels)) {
                    for (Level level : levels) {
                        if (id.equals(level.getId())) {
                            return level;
                        }
                    }
                }
            }
        }
        throw new IllegalStateException("Level with id '" + id + "' not found.");
    }

    @Override
    public Level createLevel(Factor factor, String name) {
        Level level = new Level();
        level.setId(generateUniqueIdentifier());
        level.setFactor(factor);
        level.setName(name);
        return level;
    }

    @Override
    public void removeLevel(String id) {
        Level levelToRemove = getLevelById(id);
        levelToRemove.getFactor().removeLevel(levelToRemove);
        levelToRemove.setFactor(null);
    }

    protected String generateUniqueIdentifier() {
        return UUID.randomUUID().toString();
    }

}
