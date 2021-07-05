package com.assignment.bookstore.controller;

import com.assignment.bookstore.service.BookService;
import com.assignment.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BookService bookService;

    @GetMapping({"/", "/home"})
    public String getHome(Model model) {
        return "index";
    }
    @GetMapping({"/shop"})
    public String getShop(Model model) {
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("books",bookService.getAllBooks());
        return "shop";
    }
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id) {
        model.addAttribute("books",bookService.getBooksByCategory(id));
        return "shop";
    }
    @GetMapping("/shop/viewbook/{id}")
    public String viewBook(Model model, @PathVariable int id) {
        model.addAttribute("book",bookService.getBookById(id).get());
        return "viewBook";
    }


}
