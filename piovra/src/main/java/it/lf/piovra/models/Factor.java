package it.lf.piovra.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public class Factor {


    private String name;
    private List<Level> levels = new ArrayList<>();

    public void addLevel(Level level) {
        levels.add(level);
    }

    public void removeLevel(Level level) {
        levels.remove(level);
    }

    public void clearLevels() {
        levels.clear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
