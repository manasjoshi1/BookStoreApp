package com.assignment.bookstore.service;

import com.assignment.bookstore.model.Book;
import com.assignment.bookstore.model.Orders;
import com.assignment.bookstore.model.User;
import com.assignment.bookstore.repository.OrderRepository;
import com.assignment.bookstore.repository.UserReposirotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserReposirotry userReposirotry;
    @Autowired
    BookService bookService;

    public boolean placeOrder(Orders orders) {
        int bookId = orders.getBook();
        Book book = bookService.getBookById(bookId).get();
        if (book.getStock() > 0) {

            orderRepository.save(orders);
            bookService.updateBookStock(book.getId());
            //placeOrder
            return true;

        } else {
            return false;
        }
    }

    public List<Orders> getOrders(int id) {
        return orderRepository.findAllOrdersByUserId(id);
    }

    public  int addornot(int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userReposirotry.findUserByEmail(auth.getName());
        if (user.isPresent()) {
            Orders o = new Orders();
            o.setBook(id);
            o.setUserId(user.get().getId());
            if (placeOrder(o)) {
                return 1;
            } else {
                return 2;
            }
        }
        else return 3;
}}

