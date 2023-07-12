package com.msvc.books.controller;

import com.msvc.books.dto.BookDto;
import com.msvc.books.model.entity.BookEnt;
import com.msvc.books.service.IBookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService service;

    @Autowired
    private ModelMapper mapper;


    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable Integer id){
        Optional<BookEnt> bookOp = service.findById(id);
        if (bookOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BookDto());
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(bookOp.get(), BookDto.class));

    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll(){
        List<BookEnt> bookEntList = service.findAll();
        List<BookDto> bookDtoList = bookEntList.stream()
                .map(entity -> mapper.map(entity, BookDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDtoList);
    }

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto){
        BookEnt bookEnt = mapper.map(bookDto, BookEnt.class);
        if (bookEnt.getIdBook() != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(bookDto);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(service.save(bookEnt), BookDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto, @PathVariable Integer id){
        BookEnt bookEnt = mapper.map(bookDto, BookEnt.class);
        bookEnt.setIdBook(id);
        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapper.map(bookEnt, BookDto.class));
        }

        return ResponseEntity.ok(mapper.map(service.save(bookEnt), BookDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
