package it.lf.piovra.services;


import it.lf.piovra.models.User;

import java.util.Optional;


public interface UserService {

    User createUser(String email, String password);

   Optional<User> getUserByEmail(String email);

    User getCurrentUser();

    boolean isAnonymousUser(User user);

}
