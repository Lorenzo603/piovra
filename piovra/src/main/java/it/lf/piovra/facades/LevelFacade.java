package it.lf.piovra.facades;

import it.lf.piovra.views.LevelData;

public interface LevelFacade {

    LevelData addLevel(String experimentId, String factorId, String name);

    LevelData editLevel(String experimentId, String factorId, String id, String name);

    void removeLevel(String experimentId, String factorId, String id);

}
