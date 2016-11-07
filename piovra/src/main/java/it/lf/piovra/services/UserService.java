package it.lf.piovra.services;


import it.lf.piovra.models.User;

public interface UserService {

    User getCurrentUser();

    boolean isAnonymousUser(User user);

}
