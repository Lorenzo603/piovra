package it.lf.piovra.services.impl;

import it.lf.piovra.models.Level;
import it.lf.piovra.services.LevelConverter;
import it.lf.piovra.views.LevelData;

/**
 * Created by Lorenzo on 16/05/2016.
 */
public class LevelConverterImpl implements LevelConverter {

    @Override
    public LevelData convert(Level source) {
        return convert(source, new LevelData());
    }

    @Override
    public LevelData convert(Level source, LevelData target) {
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

}
