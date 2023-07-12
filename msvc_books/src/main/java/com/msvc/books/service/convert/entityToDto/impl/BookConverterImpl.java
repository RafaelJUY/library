package com.msvc.books.service.convert.entityToDto.impl;

import com.msvc.books.dto.BookDto;
import com.msvc.books.model.entity.BookEnt;
import com.msvc.books.service.convert.entityToDto.IBookConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BookConverterImpl implements IBookConverter<BookEnt, BookDto> {

    @Autowired
    private ModelMapper mapper;
    @Override
    public BookDto entityToDto(BookEnt bookEnt) {
        return mapper.map(bookEnt, BookDto.class);
    }

    @Override
    public BookEnt dtoToEntity(BookDto bookDto) {
        return mapper.map(bookDto, BookEnt.class);
    }
}
