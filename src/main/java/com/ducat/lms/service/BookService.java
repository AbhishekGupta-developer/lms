package com.ducat.lms.service;

import com.ducat.lms.entity.Book;

import java.util.List;

public interface BookService {

    public Book getBook(Long id);
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public Book updateBook(Long id, Book book);
    public String removeBook(Long id);
}
