package it.lf.piovra.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

public class User {

    @Id
    private String email;
    @DBRef
    private List<Experiment> experiments = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Experiment> getExperiments() {
        return experiments;
    }

    public void addExperiment(Experiment experiment) {
        this.experiments.add(experiment);
    }

    public void removeExperiment(Experiment experiment) {
        this.experiments.remove(experiment);
    }
}
