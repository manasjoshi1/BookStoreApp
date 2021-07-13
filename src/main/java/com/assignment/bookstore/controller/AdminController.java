package com.assignment.bookstore.controller;

import com.assignment.bookstore.dto.BookDTO;
import com.assignment.bookstore.model.Book;
import com.assignment.bookstore.model.Category;
import com.assignment.bookstore.service.BookService;
import com.assignment.bookstore.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Api(value="Admin", description="Admin inventory management")
@Controller
@EnableAutoConfiguration
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BookService bookService;
    @ApiOperation("Go to Admin Home")
    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }
    @ApiOperation("Get Admin Categories")
    @GetMapping("/admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @PostMapping("/admin/categories/add")
    public String postAddCategory(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.findCategoryByID(id);
        if (category.isPresent()) {
            model.addAttribute("category", category);
            return "categoriesAdd";
        } else {
            return "redirect:/admin/categories";
        }
    }

    //Book Section

    @GetMapping("/admin/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/admin/books/add")
    public String getAddBook(Model model) {
        model.addAttribute("BookDTO", new BookDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "booksAdd";
    }

    @PostMapping("/admin/books/add")
    public String postAddBook(@ModelAttribute("BookDTO") BookDTO bookDTO) {
        Book book = bookService.dtoToBook(bookDTO);
        bookService.addBook(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/admin/books/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books";
    }

    @GetMapping("/admin/books/update/{id}")
    public String updateBook(@PathVariable int id, Model model) {
        BookDTO bookDTO = bookService.dtoToBooker(id);
        model.addAttribute("BookDTO", bookDTO);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "booksAdd";
    }


}
