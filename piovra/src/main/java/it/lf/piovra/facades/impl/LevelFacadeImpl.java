package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.LevelFacade;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.services.FactorService;
import it.lf.piovra.services.LevelConverter;
import it.lf.piovra.services.LevelService;
import it.lf.piovra.views.LevelData;

import javax.annotation.Resource;

public class LevelFacadeImpl implements LevelFacade {

    @Resource
    private FactorService factorService;
    @Resource
    private LevelService levelService;
    @Resource
    private LevelConverter levelConverter;

    @Override
    public LevelData addLevel(String name, String factorId) {
        Factor factor = factorService.getFactorById(factorId);
        Level level = levelService.createLevel(factor, name);
        factorService.addLevel(level, factor);
        return levelConverter.convert(level);
    }

    @Override
    public LevelData editLevel(String id, String name) {
        Level level = levelService.getLevelById(id);
        level.setName(name);
        return levelConverter.convert(level);
    }

    @Override
    public void removeLevel(String id) {
        levelService.removeLevel(id);
    }


}
