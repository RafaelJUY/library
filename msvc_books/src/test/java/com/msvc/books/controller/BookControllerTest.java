package com.msvc.books.controller;

import static com.msvc.books.BookData.*;
import static com.msvc.books.AuthorData.*;
import static com.msvc.books.service.convert.entityToDto.BookConverter.*;
import static com.msvc.books.service.convert.entityToDto.AuthorConverter.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msvc.books.dto.AuthorDto;
import com.msvc.books.dto.BookDto;
import com.msvc.books.model.entity.AuthorEnt;
import com.msvc.books.model.entity.BookAuthor;
import com.msvc.books.model.entity.BookAuthorPK;
import com.msvc.books.model.entity.BookEnt;
import com.msvc.books.service.IAuthorService;
import com.msvc.books.service.IBookAuthorService;
import com.msvc.books.service.IBookService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private IBookService bookService;

    @MockBean
    private IAuthorService authorService;

    @MockBean
    private IBookAuthorService bookAuthorService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void findById() throws Exception {
        Mockito.when(bookService.findById(1)).thenReturn(createBook001());

        mvc.perform(MockMvcRequestBuilders.get("/books/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idBook").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("title_1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(10));

        Mockito.verify(bookService).findById(1);
    }

    @Test
    void findByTitle() throws Exception {
        Mockito.when(bookService.findByTitle("_1")).thenReturn(Arrays.asList(createBook001()));

        mvc.perform(MockMvcRequestBuilders.get("/books/find-title").param("title", "_1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idBook").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("title_1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity").value(10));
    }

    @Test
    void findAll() throws Exception {
        Mockito.when(bookService.findAll()).thenReturn(allBooks());

        mvc.perform(MockMvcRequestBuilders.get("/books").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(allBooks())));

        Mockito.verify(bookService).findAll();
    }

    @Test
    void save() throws JsonProcessingException, Exception {
        //Given
        BookEnt bookEnt = new BookEnt(null, "title_4", (byte)40);
        Mockito.when(bookService.save(Mockito.any())).then(invocation -> {
            BookEnt b = invocation.getArgument(0);
            b.setIdBook(4);
            return b;
        });

        //when
        mvc.perform(MockMvcRequestBuilders.post("/books").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookEnt)))
        //Then
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idBook").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("title_4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(40));

        Mockito.verify(bookService).save(Mockito.any());


    }

    @Test
    void assignAuthors() throws Exception {
        List<Integer> idsAuthors = Arrays.asList(1,2);

//        Mockito.when(bookService.existsById(3)).thenReturn(true);
//        Mockito.when(authorService.existsAllById(idsAuthors)).thenReturn(true);
        Mockito.when(bookService.findById(3)).thenReturn(createBook003());
        Mockito.when(authorService.findAllById(idsAuthors)).thenReturn(Arrays.asList(createAuthor001(),createAuthor002()));

        Mockito.when(bookAuthorService.save(new BookAuthor(createAuthor001(), createBook003()))).thenReturn(Mockito.any());
        Mockito.when(bookAuthorService.save(new BookAuthor(createAuthor002(), createBook003()))).thenReturn(Mockito.any());

        mvc.perform(MockMvcRequestBuilders.put("/books/assign-authors/3").param("idsAuthors", "1,2"))
                .andExpect(MockMvcResultMatchers.status().isOk());

//        Mockito.verify(bookService).existsById(3);
//        Mockito.verify(authorService).existsAllById(Mockito.any());
        Mockito.verify(bookService).findById(3);
        Mockito.verify(authorService).findAllById(Mockito.any());
        Mockito.verify(bookAuthorService, Mockito.times(2)).save(Mockito.any());
    }

    @Test
    void update() throws Exception {
        BookDto bookDto = new BookDto(1, "new_title", (byte) 100, null);
        Mockito.when(bookService.existsById(1)).thenReturn(true);
        Mockito.when(bookService.save(createBook001())).then(invocation -> {
            BookEnt bookEnt = invocation.getArgument(0);
            bookEnt.setTitle("new_title");
            bookEnt.setQuantity((byte)100);
            return bookEnt;
        });

        mvc.perform(MockMvcRequestBuilders.put("/books/1")
                .content(objectMapper.writeValueAsString(bookDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("new_title"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(100));

        Mockito.verify(bookService).existsById(1);
        Mockito.verify(bookService).save(Mockito.any(BookEnt.class));
    }

    @Test
    void unassignAuthors() throws Exception {
        BookAuthor bookAuthor = new BookAuthor(createAuthor001(), createBook002());
        BookAuthorPK bookAuthorPK = new BookAuthorPK(createAuthor001(), createBook002());

        Mockito.when(bookAuthorService.findById(bookAuthorPK)).thenReturn(bookAuthor);
        Mockito.when(authorService.findById(1)).thenReturn(createAuthor001());
        Mockito.when(bookService.findById(2)).thenReturn(createBook002());
        Mockito.doAnswer(i -> null).when(bookAuthorService).delete(bookAuthor);
        //Mockito.when(bookAuthorService.deleteById(bookAuthorPK));

        mvc.perform(MockMvcRequestBuilders.put("/books/unassign-authors/2/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(bookAuthorService).findById(bookAuthorPK);
        Mockito.verify(authorService).findById(createAuthor001().getIdAuthor());
        Mockito.verify(bookService).findById(createBook002().getIdBook());
        Mockito.verify(bookAuthorService).delete(bookAuthor);
    }
}