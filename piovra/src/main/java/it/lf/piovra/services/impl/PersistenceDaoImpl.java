package it.lf.piovra.services.impl;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import it.lf.piovra.models.Experiment;
import it.lf.piovra.services.PersistenceDao;
import org.bson.Document;

public class PersistenceDaoImpl implements PersistenceDao {



    @Override
    public Experiment getExperimentById(String experimentId) {

        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("piovra");
        FindIterable<Document> experiments = db.getCollection("experiments").find(new Document("id", experimentId));
        experiments.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.print(document);
            }
        });

        Experiment result = new Experiment();
        return result;
    }


}
