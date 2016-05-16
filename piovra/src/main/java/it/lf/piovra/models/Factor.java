package it.lf.piovra.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public class Factor {

    private String id;
    private String name;
    private List<Level> levels = new ArrayList<>();

    public void addLevel(Level level) {
        levels.add(level);
    }

    public void removeLevel(Level level) {
        levels.remove(level);
    }

    public void clearLevels() {
        for (Level level : levels) {
            level.setFactor(null);
        }
        levels.clear();
    }

    public List<Level> getLevels() {
        return levels;
    }

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


}
