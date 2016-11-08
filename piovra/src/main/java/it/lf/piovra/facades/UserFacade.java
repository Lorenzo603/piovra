package it.lf.piovra.facades;

import it.lf.piovra.facades.data.RegistrationResult;

public interface UserFacade {

    RegistrationResult registerUser(String email, String password);

}
