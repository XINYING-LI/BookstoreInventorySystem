package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookEntity;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        BookEntity entity = new BookEntity();
        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setQuantityInStock(book.getQuantityInStock());
        bookRepository.save(entity);
    }

    @Override
    public void removeBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public void updateQuantity(Long bookId, int newQuantity) {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            BookEntity entity = optionalBook.get();
            entity.setQuantityInStock(newQuantity);
            bookRepository.save(entity);
        }
    }

    @Override
    public int getQuantity(Long bookId) {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
        return optionalBook.map(BookEntity::getQuantityInStock).orElse(-1);
    }

    @Override
    public List<Book> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream()
                .map(entity -> new Book(entity.getId().toString(), entity.getTitle(), entity.getAuthor(),
                        entity.getQuantityInStock()))
                .collect(Collectors.toList());
    }
}
