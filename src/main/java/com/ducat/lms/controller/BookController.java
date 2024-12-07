package com.ducat.lms.controller;

import com.ducat.lms.dto.BookInputDto;
import com.ducat.lms.dto.BookOutputDto;
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
    public ResponseEntity<BookOutputDto> getBook(@RequestParam Long id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookOutputDto>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<BookOutputDto> addBook(@RequestBody BookInputDto bookInputDto) {
        return new ResponseEntity<>(bookService.addBook(bookInputDto), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookOutputDto> updateBook(@PathVariable Long id, @RequestBody BookInputDto bookInputDto) {
        return new ResponseEntity<>(bookService.updateBook(id, bookInputDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> removeBook(@RequestParam Long id) {
        return new ResponseEntity<>(bookService.removeBook(id), HttpStatusCode.valueOf(200));
    }

}
