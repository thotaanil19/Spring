package com.example.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gateway.bean.auth.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);
}
