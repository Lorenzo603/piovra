package it.lf.piovra.services.impl;

import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.services.FactorConverter;
import it.lf.piovra.services.LevelConverter;
import it.lf.piovra.views.FactorData;
import it.lf.piovra.views.LevelData;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class FactorConverterImpl implements FactorConverter {

    @Resource
    private LevelConverter levelConverter;

    @Override
    public FactorData convert(Factor source) {
       return convert(source, new FactorData());
    }

    @Override
    public FactorData convert(Factor source, FactorData target) {
        target.setId(source.getId());
        target.setName(source.getName());

        List<LevelData> levels = new ArrayList<>();
        for (Level level : source.getLevels()) {
            levels.add(levelConverter.convert(level));
        }
        target.setLevels(levels);
        return target;
    }

}
