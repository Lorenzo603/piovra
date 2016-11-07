package it.lf.piovra.services.impl;


import it.lf.piovra.models.User;
import it.lf.piovra.services.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserServiceImpl  implements UserService {

    private static final String ANONYMOUS_USER_EMAIL = "anonymous";

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
