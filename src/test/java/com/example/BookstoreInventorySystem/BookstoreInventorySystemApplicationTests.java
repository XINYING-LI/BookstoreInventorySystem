package com.example.BookstoreInventorySystem;

import com.example.BookstoreInventorySystem.entity.Book;
import com.example.BookstoreInventorySystem.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class BookstoreInventorySystemApplicationTests {

	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveAndFindBook() {

        Book book = new Book();
        book.setTitle("Sample Book");
        book.setAuthor("Test Author");
        book.setIsbn("12345");
        book.setPrice(29.99);
        book.setQuantityInStock(10);

        
        entityManager.persist(book);
        entityManager.flush();

  
        Book foundBook = bookRepository.findById(book.getId()).orElse(null);
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getTitle()).isEqualTo("Sample Book");
    }

}
