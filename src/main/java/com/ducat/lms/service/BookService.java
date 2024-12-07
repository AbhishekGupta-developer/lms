package com.ducat.lms.service;

import com.ducat.lms.dto.BookInputDto;
import com.ducat.lms.dto.BookOutputDto;

import java.util.List;

public interface BookService {

    public BookOutputDto getBook(Long id);
    public List<BookOutputDto> getAllBooks();
    public BookOutputDto addBook(BookInputDto bookInputDto);
    public BookOutputDto updateBook(Long id, BookInputDto bookInputDto);
    public String removeBook(Long id);
}
