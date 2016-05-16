package it.lf.piovra.facades;

import it.lf.piovra.views.LevelData;

/**
 * Created by Lorenzo on 16/05/2016.
 */
public interface LevelFacade {

    LevelData addLevel(String name, String factorId);

    LevelData editLevel(String id, String name);

    void removeLevel(String id);

}
