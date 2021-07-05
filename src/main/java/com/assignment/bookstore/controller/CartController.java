package com.assignment.bookstore.controller;

import com.assignment.bookstore.dto.OrderDTO;
import com.assignment.bookstore.model.Orders;
import com.assignment.bookstore.model.User;
import com.assignment.bookstore.repository.UserReposirotry;
import com.assignment.bookstore.service.BookService;
import com.assignment.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    BookService bookService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserReposirotry userReposirotry;

    @GetMapping("purchaseBook/{id}")
    public String placeOrder( @PathVariable int id) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            System.out.println(auth.getName());

            Optional<User> user = userReposirotry.findUserByEmail(auth.getName());
            if (user.isPresent()) {
                Orders o = new Orders();
                o.setBook(id);
                o.setUserId(user.get().getId());
               boolean status=  orderService.placeOrder(o);
                if (status )return "redirect:/shop?status=true";
                else return "redirect:/shop?status=false";
            } else {
                return "redirect:/login";
            }
        }
        catch (Exception e){
            return "redirect:/shop";
        }


    }
    @GetMapping("myorders")
    public void getOrders(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userReposirotry.findUserByEmail(auth.getName());
        if (user.isPresent()) {
            int id = user.get().getId();
            List<Orders> ordersList = orderService.getOrders(id);
            model.addAttribute("orders",ordersList);
        }

    }


}
