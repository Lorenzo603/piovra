package it.lf.piovra.services;


import it.lf.piovra.models.User;

public interface UserService {

    User createUser(String email, String password);

    User getUserByEmail(String email);

    User getCurrentUser();

    boolean isAnonymousUser(User user);

}
