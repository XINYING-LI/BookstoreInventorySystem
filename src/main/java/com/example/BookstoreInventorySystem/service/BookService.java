package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import java.util.List;

public interface BookService {

    void addBook(Book book);

    void removeBook(Long bookId);

    void updateQuantity(Long bookId, int newQuantity);

    int getQuantity(Long bookId);

    List<Book> getAllBooks();

    // import exception
    if(requestedQuantity>quantityInStock)

    {
        throw new InsufficientStockException("Insufficient stock for the requested quantity");
    }
}
