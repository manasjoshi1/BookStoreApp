package com.assignment.bookstore.repository;

import com.assignment.bookstore.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findAllOrdersByUserId(int id);

}
