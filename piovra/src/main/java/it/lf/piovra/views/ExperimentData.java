package it.lf.piovra.views;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lfurrer on 04/05/2016.
 */
public class ExperimentData {

    private List<FactorData> factors = new ArrayList<>();

    public List<FactorData> getFactors() {
        return factors;
    }

    public void setFactors(List<FactorData> factors) {
        this.factors = factors;
    }

    public void addFactor(FactorData factor) {
        this.factors.add(factor);
    }
}
