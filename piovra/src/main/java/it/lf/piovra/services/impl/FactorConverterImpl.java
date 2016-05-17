package it.lf.piovra.services.impl;

import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.services.FactorConverter;
import it.lf.piovra.services.LevelConverter;
import it.lf.piovra.views.FactorData;
import it.lf.piovra.views.LevelData;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public class FactorConverterImpl implements FactorConverter {

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

    @Required
    public void setLevelConverter(LevelConverter levelConverter) {
        this.levelConverter = levelConverter;
    }
}
