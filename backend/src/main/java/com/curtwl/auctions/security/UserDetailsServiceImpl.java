package com.curtwl.auctions.security;

import com.curtwl.auctions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public UserDetailsServiceImpl() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("pw"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("pw"))
                .roles("ADMIN")
                .build();
        this.inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user, admin);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User " + username + " not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//        return User.withUsername("admin")
//                .password(encodedPassword)
//                .roles("USER")
//                .build();
        return inMemoryUserDetailsManager.loadUserByUsername(username);
    }
}
