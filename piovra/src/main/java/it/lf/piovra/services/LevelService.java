package it.lf.piovra.services;

import it.lf.piovra.models.Level;

/**
 * Created by Lorenzo on 16/05/2016.
 */
public interface LevelService {

    Level getLevelById(String id);

    Level createLevel(String name);


}
