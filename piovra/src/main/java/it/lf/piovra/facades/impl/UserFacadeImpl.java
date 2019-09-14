package it.lf.piovra.facades.impl;


import it.lf.piovra.facades.UserFacade;
import it.lf.piovra.facades.data.RegistrationResult;
import it.lf.piovra.facades.data.RegistrationResultStatus;
import it.lf.piovra.models.User;
import it.lf.piovra.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserFacadeImpl implements UserFacade {

    @Resource
    private UserService userService;

    @Override
    public RegistrationResult registerUser(String email, String password) {
        Optional<User> existingUser = userService.getUserByEmail(email);
        if (existingUser.isPresent()) {
            return new RegistrationResult(RegistrationResultStatus.USER_ALREADY_REGISTERED, "register.user.already.exists");
        }
        User user = userService.createUser(email, password);
        if (user == null) {
            return new RegistrationResult(RegistrationResultStatus.ERROR, "register.error");
        }
        return new RegistrationResult(RegistrationResultStatus.OK);
    }

}
