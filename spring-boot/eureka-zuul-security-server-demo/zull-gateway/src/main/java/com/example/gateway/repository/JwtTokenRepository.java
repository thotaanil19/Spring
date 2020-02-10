package com.example.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gateway.bean.auth.JwtToken;

@Repository
public interface JwtTokenRepository extends JpaRepository<JwtToken,String> {
}
