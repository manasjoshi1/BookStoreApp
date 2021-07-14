package com.assignment.bookstore.controller;

import com.assignment.bookstore.BookStoreApplication;
import com.assignment.bookstore.service.BookService;
import com.assignment.bookstore.service.CategoryService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j2
//@Api(value = "Home Controller", description = "Home Page ")
public class HomeController {


    @Autowired
    CategoryService categoryService;
    @Autowired
    BookService bookService;

//    @ApiOperation(value = "View a list of available products", response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    }
//    )
    @GetMapping({"/", "/home"})
    public String getHome(Model model) {
        log.info("Hello");
        return "index";
    }

    @GetMapping({"/shop"})
    public String getShop(Model model) {
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("books",bookService.getAllBooks());
        return "shop";
    }

//    @ApiOperation(value = "Get Shop by id")
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id) {
        model.addAttribute("books",bookService.getBooksByCategory(id));
        return "shop";
    }
//    @ApiOperation(value = "Delete a product")
    @RequestMapping(value = "/shop/viewbook/{id}",method = RequestMethod.GET)
    public String viewBook(Model model, @PathVariable int id) {
        model.addAttribute("book",bookService.getBookById(id).get());
        return "viewBook";
    }


}
