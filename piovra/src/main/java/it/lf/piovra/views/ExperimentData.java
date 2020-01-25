package it.lf.piovra.views;

import java.util.ArrayList;
import java.util.List;

public class ExperimentData {

    private String id;
    private String name;
    private String timeCreated;

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
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
