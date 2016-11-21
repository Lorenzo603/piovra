package it.lf.piovra.views;

import java.util.List;

public class SuiteData {

    private String experimentId;
    private List<List<String>> cases;
    private List<String> factorNames;

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public List<List<String>> getCases() {
        return cases;
    }

    public void setCases(List<List<String>> cases) {
        this.cases = cases;
    }

    public List<String> getFactorNames() {
        return factorNames;
    }

    public void setFactorNames(List<String> factorNames) {
        this.factorNames = factorNames;
    }


}
