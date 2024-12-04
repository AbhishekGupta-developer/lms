package com.ducat.lms.service;

import com.ducat.lms.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private Map<Long, Book> books = new HashMap<>();

    @Override
    public Book getBook(Long id) {
        return books.get(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book addBook(Book book) {
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book updateBook(Long id, Book book) {
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public String removeBook(Long id) {
        books.remove(id);
        return "Book id: " + id + " successfully removed.";
    }
}
