package com.example.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.gateway.bean.auth.PrincipalUser;
import com.example.gateway.bean.auth.Role;
import com.example.gateway.bean.auth.User;
import com.example.gateway.exception.CustomException;
import com.example.gateway.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null /*|| user.getRole() == null || user.getRole().isEmpty()*/) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        String [] authorities = {"USER"};//new String[user.getRole().size()];
        /*for (Role role : user.getRole()) {
            authorities[count] = "ROLE_"+role.getRole();
            count++;
        }*/
        UserDetails userDetails = new PrincipalUser(user.getEmail(),user.getPassword(),user.getActive(),
                user.isLoacked(), user.isExpired(),user.isEnabled(),authorities);
        return userDetails;
    }



}
