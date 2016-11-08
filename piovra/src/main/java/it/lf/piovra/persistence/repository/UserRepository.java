package it.lf.piovra.persistence.repository;


import it.lf.piovra.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
