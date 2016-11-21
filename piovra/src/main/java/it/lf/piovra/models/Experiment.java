package it.lf.piovra.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Experiment {

    @Id
    private String id;
    @DBRef
    private User user;
    private String name;
    private String timeCreated;

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


    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }
}
