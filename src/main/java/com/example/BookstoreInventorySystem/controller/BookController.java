package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/sell")
    public void sellBook(int quantityInStock, int requestedQuantity) {
        try {
            bookService.sellBook(quantityInStock, requestedQuantity);
        } catch (InsufficientStockException e) {
            throw new InsufficientStockException("Insufficient stock for the requested quantity");
        }
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void removeBook(@PathVariable String bookId) {
        bookService.removeBook(bookId);
    }

    @PutMapping("/{bookId}")
    public void updateQuantity(@PathVariable String bookId, @RequestParam int newQuantity) {
        bookService.updateQuantity(bookId, newQuantity);
    }

    @GetMapping("/{bookId}/quantity")
    public int getQuantity(@PathVariable String bookId) {
        return bookService.getQuantity(bookId);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}