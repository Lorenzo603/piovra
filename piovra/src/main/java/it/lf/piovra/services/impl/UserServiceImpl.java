package it.lf.piovra.services.impl;


import it.lf.piovra.models.User;
import it.lf.piovra.persistence.services.PersistenceDao;
import it.lf.piovra.services.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    private static final String ANONYMOUS_USER_EMAIL = "anonymous";

    @Resource
    private PersistenceDao persistenceDao;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setEncodedPassword(passwordEncoder.encode(password));
        persistenceDao.persistUser(user);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return persistenceDao.getUserByEmail(email);
    }

    @Override
    public User getCurrentUser() {
        User user = new User();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            user.setEmail(ANONYMOUS_USER_EMAIL);
        } else {
            user.setEmail(authentication.getName());
        }
        return user;
    }

    @Override
    public boolean isAnonymousUser(User user) {
        return ANONYMOUS_USER_EMAIL.equals(user.getEmail());
    }

}
