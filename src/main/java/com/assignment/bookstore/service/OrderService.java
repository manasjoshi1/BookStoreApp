package com.assignment.bookstore.service;

import com.assignment.bookstore.model.Book;
import com.assignment.bookstore.model.Orders;
import com.assignment.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookService bookService;

    public boolean placeOrder(Orders orders){
        int bookId=orders.getBook();
        Book book= bookService.getBookById(bookId).get();
        if(book.getStock()>0){

            orderRepository.save(orders);
            bookService.updateBookStock(book.getId());
            //placeOrder
            return true;

        }
        else
        {
            return false;
        }
}
   public List<Orders> getOrders(int id){return orderRepository.findAllOrdersByUserId(id);};
}

