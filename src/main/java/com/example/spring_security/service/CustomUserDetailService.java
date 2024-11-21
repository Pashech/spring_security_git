package com.example.spring_security.service;

import com.example.spring_security.model.MyUser;
import com.example.spring_security.repository.MyUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final MyUserRepository dao;

    public CustomUserDetailService(MyUserRepository dao) {
        this.dao = dao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = dao.findByLogin(username);

        if(myUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + username);
        }

        return User.builder()
                .username(myUser.getLogin())
                .password(myUser.getPassword())
                .roles(myUser.getRole())
                .build();
    }
}
