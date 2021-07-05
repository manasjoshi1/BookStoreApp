package com.assignment.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int id;


    private int userId;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "ids",referencedColumnName = "book_id")
    private int book;
}
