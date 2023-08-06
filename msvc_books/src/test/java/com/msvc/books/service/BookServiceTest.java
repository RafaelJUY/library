package com.msvc.books.service;


import static com.msvc.books.BookData.*;

import com.msvc.books.exception.ModelNotFoundException;
import com.msvc.books.model.entity.BookEnt;
import com.msvc.books.repository.IBookRepository;
import com.msvc.books.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookServiceImpl service;
    @MockBean
    private IBookRepository repo;

//    private BookEnt BOOK_ENT_1 = new BookEnt(1, "title_1", (byte) 10);
//    private BookEnt BOOK_ENT_2 = new BookEnt(2, "title_2", (byte) 20);
//    private BookEnt BOOK_ENT_3 = new BookEnt(3, "title_3", (byte) 30);
//
//    List<BookEnt> dataList = Arrays.asList(BOOK_ENT_1, BOOK_ENT_2, BOOK_ENT_3);

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);

//        BookEnt BOOK_ENT_1 = new BookEnt(1, "titulo_1", (byte) 10);
//        BookEnt BOOK_ENT_2 = new BookEnt(2, "titulo_2", (byte) 20);
//        BookEnt BOOK_ENT_3 = new BookEnt(3, "titulo_3", (byte) 30);

//        List<BookEnt> datos = Arrays.asList(BOOK_ENT_1, BOOK_ENT_2, BOOK_ENT_3);
    }

    @Test
    void findAllTest() throws Exception {
        Mockito.when(repo.findAll()).thenReturn(allBooks());
        List<BookEnt> bookEntList = service.findAll();

        Assertions.assertNotNull(bookEntList);
        Assertions.assertFalse(bookEntList.isEmpty());
        Assertions.assertEquals(bookEntList.size(), 3);

        Mockito.verify(repo).findAll();
    }

    @Test
    void findByIdTest() throws Exception {
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(createBook001()));
        BookEnt bookEnt1 = service.findById(1);
        BookEnt bookEnt2 = service.findById(1);

        Assertions.assertSame(bookEnt1, bookEnt2);

        Assertions.assertEquals("title_1", bookEnt1.getTitle());
        Assertions.assertEquals(1, bookEnt1.getIdBook());
        Assertions.assertEquals((byte) 10, bookEnt1.getQuantity());

        Mockito.verify(repo, Mockito.times(2)).findById(1);
    }

    @Test
    void findByIdExceptionTest() {
        Mockito.when(repo.findById(5)).thenReturn(Optional.empty());
        Assertions.assertThrows(ModelNotFoundException.class, () -> {
            service.findById(5);
        });
    }

    @Test
    @Disabled
    void deleteById() throws Exception {
        // FALTA COMPLETAR !!
        service.deleteById(1);
    }
}
