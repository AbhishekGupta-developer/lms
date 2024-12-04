package com.ducat.lms.entity;

import lombok.Data;

@Data
public class Book {

    private Long id;
    private String name;
    private String author;
    private Double price;

}
