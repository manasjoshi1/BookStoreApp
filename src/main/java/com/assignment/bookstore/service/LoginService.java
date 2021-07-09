package com.assignment.bookstore.service;

import com.assignment.bookstore.model.Role;
import com.assignment.bookstore.model.User;
import com.assignment.bookstore.repository.RoleRepository;
import com.assignment.bookstore.repository.UserReposirotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class LoginService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserReposirotry userReposirotry;
    @Autowired
    RoleRepository roleRepository;

    public void loginCheck(User user, HttpServletRequest request) throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        user.setRoles(roles);
        userReposirotry.save(user);
        request.login(user.getEmail(), password);
    }
}