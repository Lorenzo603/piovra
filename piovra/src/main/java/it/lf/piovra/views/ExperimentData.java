package it.lf.piovra.views;

import java.util.ArrayList;
import java.util.List;

public class ExperimentData {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
