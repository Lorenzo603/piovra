package it.lf.piovra.views;

import java.util.List;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public class FactorData {

    private String id;
    private String name;
    private List<LevelData> levels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<LevelData> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelData> levels) {
        this.levels = levels;
    }
}
