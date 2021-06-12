package com.ecommerce.colab.security;

import com.ecommerce.colab.model.Privilege;
import com.ecommerce.colab.model.Role;
import com.ecommerce.colab.model.User;
import com.ecommerce.colab.repository.RoleRepository;
import com.ecommerce.colab.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Slf4j
@Service
public class UserdetailsServiceSecurity implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).get();
        if (user == null) {
           throw new UsernameNotFoundException("unable to find user by this id");
        }


            user.getRoles().stream().forEach(x->System.out.println(x.getName()));
             return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.isEnabled(),true,true,true,getAuthorities("USER"));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
    /*
    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        log.debug("inside role");
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            log.debug(item.getName());
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
    */

}
