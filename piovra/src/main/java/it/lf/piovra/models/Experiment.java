package it.lf.piovra.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public class Experiment {

    private List<Factor> factors = new ArrayList<>();

    public void addFactor(Factor factor) {
        factors.add(factor);
    }

    public void removeFactor(Factor factor) {
        factors.remove(factor);
    }

    public void clearFactors() {
        factors.clear();
    }
}
