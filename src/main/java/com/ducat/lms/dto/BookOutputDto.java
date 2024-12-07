package com.ducat.lms.dto;

import lombok.Data;

@Data
public class BookOutputDto {

    private Long id;
    private String name;
    private String author;
    private Double price;

}
