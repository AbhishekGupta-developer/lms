package com.ducat.lms.service;

import com.ducat.lms.dto.BookInputDto;
import com.ducat.lms.dto.BookOutputDto;
import com.ducat.lms.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    // Dummy Database to store books
    private Map<Long, Book> books = new HashMap<>();

    // Dummy Id generator
    private Long bookId = 0L;
    private Long getBookId() {
        return ++bookId;
    }

    @Override
    public BookOutputDto getBook(Long id) {
        Book bookEntity = books.get(id);
        BookOutputDto bookOutputDto = new BookOutputDto();

        bookOutputDto.setId(bookEntity.getId());
        bookOutputDto.setName(bookEntity.getName());
        bookOutputDto.setAuthor(bookEntity.getAuthor());
        bookOutputDto.setPrice(bookEntity.getPrice());

        return bookOutputDto;
    }

    @Override
    public List<BookOutputDto> getAllBooks() {
        List<Book> bookEntities = new ArrayList<>(books.values());
        List<BookOutputDto> booksOutputDto = new ArrayList<>();

        for(Book bookEntity : bookEntities) {
            BookOutputDto bookOutputDto = new BookOutputDto();
            bookOutputDto.setId(bookEntity.getId());
            bookOutputDto.setName(bookEntity.getName());
            bookOutputDto.setAuthor(bookEntity.getAuthor());
            bookOutputDto.setPrice(bookEntity.getPrice());

            booksOutputDto.add(bookOutputDto);
        }

        return booksOutputDto;
    }

    @Override
    public BookOutputDto addBook(BookInputDto bookInputDto) {
        Long currentBookId = getBookId();

        Book bookEntity = new Book();
        bookEntity.setId(currentBookId);
        bookEntity.setName(bookInputDto.getName());
        bookEntity.setAuthor(bookInputDto.getAuthor());
        bookEntity.setPrice(bookInputDto.getPrice());

        books.put(currentBookId, bookEntity);

        bookEntity = books.get(currentBookId);

        BookOutputDto bookOutputDto = new BookOutputDto();
        bookOutputDto.setId(bookEntity.getId());
        bookOutputDto.setName(bookEntity.getName());
        bookOutputDto.setAuthor(bookEntity.getAuthor());
        bookOutputDto.setPrice(bookEntity.getPrice());

        return bookOutputDto;
    }

    @Override
    public BookOutputDto updateBook(Long id, BookInputDto bookInputDto) {
        Book bookEntity = new Book();
        bookEntity.setId(id);
        bookEntity.setName(bookInputDto.getName());
        bookEntity.setAuthor(bookInputDto.getAuthor());
        bookEntity.setPrice(bookInputDto.getPrice());

        books.put(id, bookEntity);

        bookEntity = books.get(id);

        BookOutputDto bookOutputDto = new BookOutputDto();
        bookOutputDto.setId(bookEntity.getId());
        bookOutputDto.setName(bookEntity.getName());
        bookOutputDto.setAuthor(bookEntity.getAuthor());
        bookOutputDto.setPrice(bookEntity.getPrice());

        return bookOutputDto;
    }

    @Override
    public String removeBook(Long id) {
        books.remove(id);
        return "Book id: " + id + " successfully removed.";
    }
}
