package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.LevelService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
import java.util.UUID;

/**
 * Created by Lorenzo on 16/05/2016.
 */
public class LevelServiceImpl implements LevelService {

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
    public Level createLevel(String name) {
        Level level = new Level();
        level.setId(generateUniqueIdentifier());
        level.setName(name);
        return level;
    }

    protected String generateUniqueIdentifier() {
        return UUID.randomUUID().toString();
    }

    @Required
    public void setExperimentService(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

}
