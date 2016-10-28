package it.lf.piovra.security.impl;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class DefaultAuthenticationProvider implements AuthenticationProvider{


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // authentication.getPrincipal()
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RememberMeAuthenticationToken.class.isAssignableFrom(aClass) || UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
