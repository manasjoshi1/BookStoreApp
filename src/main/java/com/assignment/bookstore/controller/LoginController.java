package com.assignment.bookstore.controller;

import com.assignment.bookstore.model.User;
import com.assignment.bookstore.service.LoginService;
//import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@Controller
//@Api
public class LoginController {
    @Autowired
    LoginService loginService;

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
    loginService.loginCheck(user, request);
    return "redirect:/";
    }

}
