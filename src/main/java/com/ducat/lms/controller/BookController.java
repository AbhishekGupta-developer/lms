package com.ducat.lms.controller;

import com.ducat.lms.entity.Book;
import com.ducat.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<Book> getBook(@RequestParam Long id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Long bookId = book.getId();
        return new ResponseEntity<>(bookService.updateBook(bookId, book), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> removeBook(@RequestParam Long id) {
        return new ResponseEntity<>(bookService.removeBook(id), HttpStatusCode.valueOf(200));
    }

}
