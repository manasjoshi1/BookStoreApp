package com.assignment.bookstore.controller;

import com.assignment.bookstore.model.Orders;
import com.assignment.bookstore.model.User;
import com.assignment.bookstore.repository.UserReposirotry;
import com.assignment.bookstore.service.BookService;
import com.assignment.bookstore.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@Api
public class CartController {
    @Autowired
    BookService bookService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserReposirotry userReposirotry;

    @GetMapping("purchaseBook/{id}")
    public String placeOrder(@PathVariable int id) {

        switch (orderService.addornot(id)) {
            case 1:
                return "redirect:/shop?status=true";

            case 2:
                return "redirect:/shop?status=false";
            case 3:
                return "redirect:/login";
            default:
                return "redirect:/shop";
        }
}
}
