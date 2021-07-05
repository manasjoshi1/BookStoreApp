package com.assignment.bookstore.service;

import com.assignment.bookstore.model.CustomUserDetail;
import com.assignment.bookstore.model.User;
import com.assignment.bookstore.repository.UserReposirotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserReposirotry userReposirotry;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user= userReposirotry.findUserByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("No user found"));
        return user.map(CustomUserDetail::new).get();
    }
}
