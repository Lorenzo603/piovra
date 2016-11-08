package it.lf.piovra.services;

import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;


public interface LevelService {

    Level createLevel(String experimentId, String factorId, String name);

    Level getLevelById(Factor factor, String id);

    Level updateLevel(String experimentId, String factorId, String id, String name);

    void removeLevel(String experimentId, String factorId, String id);
}
