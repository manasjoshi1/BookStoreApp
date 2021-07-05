package com.assignment.bookstore.dto;

import com.assignment.bookstore.model.Category;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
public class BookDTO {
    private int id;
    private String name;
    private int categoryId;
    private double price;
    private int stock;

}
