package com.fenast.ibextube.service;

import com.fenast.ibextube.model.User;
import com.fenast.ibextube.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by taddesee on 4/20/2018.
 */
@Service
@Qualifier(value = "UserDetailsServiceImpl")
public class UserDetailsServiceImpl  implements UserDetailsService {

//     @Autowired
//     private UserRepository userRepository;
    
    private final UserRepository userRepository;

    @Autowired
    @Qualifier(value = "userPasswordEncoder")
    private PasswordEncoder userPasswordEncoder;
    
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println(username);
        if (user != null) {
            System.out.println(user.getUsername());
            return user;
        }
        if (user == null) {
            System.out.println("User is null");
        }

        throw new UsernameNotFoundException(username);
    }

/*    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
System.out.println(username);
        UserBuilder builder = null;
        if (user != null) {
            System.out.println(username);
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(userPasswordEncoder.encode(user.getPassword()));
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }*/
}
