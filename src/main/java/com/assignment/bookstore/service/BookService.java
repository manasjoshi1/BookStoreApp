package com.assignment.bookstore.service;

import com.assignment.bookstore.dto.BookDTO;
import com.assignment.bookstore.model.Book;
import com.assignment.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryService categoryService;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByCategory(int id) {
        return bookRepository.findAllByCategoryId(id);
    }

    public void updateBookStock(int id) {
        Book book = getBookById(id).get();
        book.setStock(book.getStock() - 1);
        bookRepository.save(book);
    }

    public Book dtoToBook(BookDTO bookDTO) {

        Book book =new Book();
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setPrice(bookDTO.getPrice());
        book.setStock(bookDTO.getStock());
        book.setCategory(categoryService.findCategoryByID(bookDTO.getCategoryId()).get());

        return book;
    }
    public BookDTO dtoToBooker(int id){
        Book book=getBookById(id).get();
        BookDTO bookDTO =new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setCategoryId(book.getCategory().getId());
        bookDTO.setStock(book.getStock());
        return bookDTO;

    }
}
