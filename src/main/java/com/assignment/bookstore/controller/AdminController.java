package com.assignment.bookstore.controller;

import com.assignment.bookstore.dto.BookDTO;
import com.assignment.bookstore.model.Book;
import com.assignment.bookstore.model.Category;
import com.assignment.bookstore.service.BookService;
import com.assignment.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@EnableAutoConfiguration
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BookService bookService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }
    @GetMapping("/admin/categories")
    public String getCategories(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";
    }

    @PostMapping("/admin/categories/add")
    public  String postAddCategory(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/add")
    public  String addCategory(Model model){
        model.addAttribute("category",new Category());
        return "categoriesAdd";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable int id, Model model){
        Optional<Category> category= categoryService.findCategoryByID(id);
        if(category.isPresent())
        {        model.addAttribute("category",category);
        return "categoriesAdd";
        }
        else {
            return "redirect:/admin/categories";
        }
    }
    //Book Section
    //book view

    @GetMapping("/admin/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        return "books";
    }


    //book add
    @GetMapping("/admin/books/add")
    public  String getAddBook(Model model){
        model.addAttribute("BookDTO",new BookDTO());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "booksAdd";
    }
    @PostMapping("/admin/books/add")
    public  String postAddBook(@ModelAttribute("BookDTO") BookDTO bookDTO){

        Book book =new Book();
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setPrice(bookDTO.getPrice());
        book.setStock(bookDTO.getStock());
        book.setCategory(categoryService.findCategoryByID(bookDTO.getCategoryId()).get());
        bookService.addBook(book);
        return "redirect:/admin/books";
    }
    //book delete
    @GetMapping("/admin/books/delete/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "redirect:/admin/books";
    }
    //book update
    @GetMapping("/admin/books/update/{id}")
    public  String updateBook(@PathVariable int id ,Model model){
        Book book=bookService.getBookById(id).get();
        BookDTO bookDTO =new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setCategoryId(book.getCategory().getId());
        bookDTO.setStock(book.getStock());
        model.addAttribute("BookDTO",bookDTO);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "booksAdd";
    }




}