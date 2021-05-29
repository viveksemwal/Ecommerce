package com.ecommerce.colab.security;

import com.ecommerce.colab.model.User;
import com.ecommerce.colab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserdetailsServiceSecurity implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user=userRepository.findByEmail(email).get();
        if(user==null) {
            throw new UsernameNotFoundException("no user with the email "+email);
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.isEnabled(),true,true,true,getAuthorities("Role_CUSTOMER"));
    }


    public Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}
