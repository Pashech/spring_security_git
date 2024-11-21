package com.example.spring_security.repository;

import com.example.spring_security.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    MyUser findByLogin(String login);
}
