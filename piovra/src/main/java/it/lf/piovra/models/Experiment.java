package it.lf.piovra.models;

import java.util.ArrayList;
import java.util.List;

public class Experiment {

    private String id;
    private User user;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Factor> factors = new ArrayList<>();

    public List<Factor> getFactors() {
        return factors;
    }

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
