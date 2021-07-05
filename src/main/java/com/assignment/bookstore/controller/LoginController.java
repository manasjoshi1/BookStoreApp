package com.assignment.bookstore.controller;

import com.assignment.bookstore.model.Role;
import com.assignment.bookstore.model.User;
import com.assignment.bookstore.repository.RoleRepository;
import com.assignment.bookstore.repository.UserReposirotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserReposirotry userReposirotry;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String addRegister(@ModelAttribute("user") User user, HttpServletRequest request)throws Exception{
    String password= user.getPassword();
    user.setPassword(bCryptPasswordEncoder.encode(password));
    List<Role> roles =new ArrayList<>();
    roles.add(roleRepository.findById(2).get());
    user.setRoles(roles);
    userReposirotry.save(user);
    request.login(user.getEmail(),password);
    return "redirect:/";
    }

}
