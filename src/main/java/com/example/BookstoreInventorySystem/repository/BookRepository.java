package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Bonus point 1
    List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrIsbnContainingIgnoreCase(String title,
            String author, String isbn);

    List<Book> findByPriceBetweenAndQuantityInStockGreaterThanEqual(BigDecimal minPrice, BigDecimal maxPrice,
            int minQuantity);
}