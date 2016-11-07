package it.lf.piovra.persistence.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.persistence.repository.ExperimentRepository;
import it.lf.piovra.persistence.services.PersistenceDao;
import org.springframework.beans.factory.annotation.Autowired;

public class PersistenceDaoImpl implements PersistenceDao {

    @Autowired
    private ExperimentRepository experimentRepository;

    @Override
    public Experiment getExperimentById(String experimentId) {
/*
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("piovra");
        FindIterable<Document> experiments = db.getCollection("experiments").find(new Document("id", experimentId));
        experiments.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.print(document);
            }
        });

*/
        Experiment result = new Experiment();
        return result;
    }

    @Override
    public void persistExperiment(Experiment experiment) {
        experimentRepository.save(experiment);
    }

}
