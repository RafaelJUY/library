package com.msvc.books.repository;

import com.msvc.books.model.entity.BookEnt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    IBookRepository repo;

    @Test
    void findByIdTest() {
        Optional<BookEnt> bookOp = repo.findById(1);

        Assertions.assertTrue(bookOp.isPresent());
        BookEnt bookEnt = bookOp.get();

        Assertions.assertEquals("title_1", bookEnt.getTitle());
        Assertions.assertEquals((byte)10, bookEnt.getQuantity());
    }

    @Test
    void findByIdExceptiontTest() {
        Optional<BookEnt> bookOp = repo.findById(5);
        Assertions.assertThrows(NoSuchElementException.class, bookOp::orElseThrow);
        Assertions.assertTrue(bookOp.isEmpty());
    }

    @Test
    void findAllTest() {
        List<BookEnt> bookList = repo.findAll();
        Assertions.assertFalse(bookList.isEmpty());
        Assertions.assertEquals(3, bookList.size());
    }

    @Test
    void saveTest() {
        BookEnt newBook = new BookEnt(null, "a title", (byte) 40);

        BookEnt bookEnt = repo.save(newBook);

        Assertions.assertNotNull(bookEnt.getIdBook());
        Assertions.assertEquals("a title", bookEnt.getTitle());
        Assertions.assertEquals((byte) 40, bookEnt.getQuantity());
    }

    @Test
    void updateTest() {
        BookEnt newBook = new BookEnt(1, "a new title", (byte) 40);

        BookEnt bookEnt = repo.save(newBook);

        Assertions.assertEquals(1, bookEnt.getIdBook());
        Assertions.assertEquals("a new title", bookEnt.getTitle());
        Assertions.assertEquals((byte) 40, bookEnt.getQuantity());
    }

    @Test
    void deleteTest() {
        Assertions.assertTrue(repo.existsById(3));

        repo.deleteById(3);

        Assertions.assertFalse(repo.existsById(3));
    }

    @Test
    void findByTitleTest() {
        List<BookEnt> bookList = repo.findByTitleContainsIgnoreCase("2");

        Assertions.assertFalse(bookList.isEmpty());
        Assertions.assertEquals(1, bookList.size());
    }
}
