package it.lf.piovra.services;

import it.lf.piovra.models.Level;
import it.lf.piovra.views.LevelData;

/**
 * Created by Lorenzo on 16/05/2016.
 */
public interface LevelConverter {

    LevelData convert(Level source);

    LevelData convert(Level source, LevelData target);


}
