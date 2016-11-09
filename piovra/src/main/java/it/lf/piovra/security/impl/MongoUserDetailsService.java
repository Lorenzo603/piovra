package it.lf.piovra.security.impl;

import it.lf.piovra.models.User;
import it.lf.piovra.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOne(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new MongoUserDetails(user, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
    }


}
