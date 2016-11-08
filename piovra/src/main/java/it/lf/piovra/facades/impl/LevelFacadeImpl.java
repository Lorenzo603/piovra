package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.LevelFacade;
import it.lf.piovra.models.Level;
import it.lf.piovra.services.LevelConverter;
import it.lf.piovra.services.LevelService;
import it.lf.piovra.views.LevelData;

import javax.annotation.Resource;

public class LevelFacadeImpl implements LevelFacade {

    @Resource
    private LevelService levelService;
    @Resource
    private LevelConverter levelConverter;

    @Override
    public LevelData addLevel(String experimentId, String factorId, String name) {
        Level level = levelService.createLevel(experimentId, factorId, name);
        return levelConverter.convert(level);
    }

    @Override
    public LevelData editLevel(String experimentId, String factorId, String id, String name) {
        Level level = levelService.updateLevel(experimentId, factorId, id, name);
        return levelConverter.convert(level);
    }

    @Override
    public void removeLevel(String experimentId, String factorId, String id) {
        levelService.removeLevel(experimentId, factorId, id);
    }


}
