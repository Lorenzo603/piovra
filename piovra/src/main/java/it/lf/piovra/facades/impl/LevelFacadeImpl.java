package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.LevelFacade;
import it.lf.piovra.models.Level;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.FactorService;
import it.lf.piovra.services.LevelConverter;
import it.lf.piovra.services.LevelService;
import it.lf.piovra.views.LevelData;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by Lorenzo on 16/05/2016.
 */
public class LevelFacadeImpl implements LevelFacade {

    private FactorService factorService;
    private LevelService levelService;
    private LevelConverter levelConverter;

    @Override
    public LevelData addLevel(String name, String factorId) {
        Level level = levelService.createLevel(name);
        factorService.addLevel(level, factorId);
        return levelConverter.convert(level);
    }

    @Override
    public LevelData editLevel(String id, String name) {
        Level level = levelService.getLevelById(id);
        level.setName(name);
        return levelConverter.convert(level);
    }

    @Required
    public void setFactorService(FactorService factorService) {
        this.factorService = factorService;
    }

    @Required
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

    @Required
    public void setLevelConverter(LevelConverter levelConverter) {
        this.levelConverter = levelConverter;
    }


}
