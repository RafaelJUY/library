package com.msvc.books.controller;

import com.msvc.books.dto.BookDto;
import com.msvc.books.exception.ModelKeyAutogeneratedException;
import com.msvc.books.exception.ModelNotFoundException;
import com.msvc.books.model.entity.BookEnt;
import com.msvc.books.service.IBookService;
import com.msvc.books.service.convert.entityToDto.IBookConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService service;

    @Autowired
    private IBookConverter<BookEnt, BookDto> convert;


    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable Integer id) throws Exception{
        Optional<BookEnt> bookOp = service.findById(id);
        if (bookOp.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND ".concat(id.toString()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(convert.entityToDto(bookOp.get())); //mapper.map(bookOp.get(), BookDto.class)

    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll() throws Exception{
        List<BookEnt> bookEntList = service.findAll();
        List<BookDto> bookDtoList = convert.entityListToDtoList(bookEntList);
        return ResponseEntity.ok(bookDtoList);
    }

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto) throws Exception{
        BookEnt bookEnt = convert.dtoToEntity(bookDto); //mapper.map(bookDto, BookEnt.class)
        if (bookEnt.getIdBook() != null){
            throw new ModelKeyAutogeneratedException("The primary key is autogenerated: ".concat(bookEnt.getIdBook().toString()));
            //return ResponseEntity.status(HttpStatus.CONFLICT).body(bookDto);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(convert.entityToDto(service.save(bookEnt))); //mapper.map(service.save(bookEnt), BookDto.class)
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto, @PathVariable Integer id) throws Exception{
        BookEnt bookEnt = convert.dtoToEntity(bookDto); //mapper.map(bookDto, BookEnt.class)
        bookEnt.setIdBook(id);
        if(!service.existsById(id)){
            throw new ModelNotFoundException("ID NOT FOUND ".concat(id.toString()));
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(convert.entityToDto(bookEnt)); //mapper.map(bookEnt, BookDto.class)
        }

        return ResponseEntity.ok(convert.entityToDto(service.save(bookEnt))); //mapper.map(service.save(bookEnt), BookDto.class)
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) throws Exception{
        if(!service.existsById(id)){
            throw new ModelNotFoundException("ID NOT FOUND ".concat(id.toString()));
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
