package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private final Map<Long, Book> books = new HashMap<>();
    private long nextId = 1L;

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(Long id) {
        return books.get(id);
    }

    public Book createBook(Book book) {
        book.setId(nextId++);
        books.put(book.getId(), book);
        return book;
    }

    public Book updateBook(Long id, Book updatedBook) {
        if (!books.containsKey(id)) return null;
        updatedBook.setId(id);
        books.put(id, updatedBook);
        return updatedBook;
    }

    public void deleteBook(Long id) {
        books.remove(id);
    }
}
