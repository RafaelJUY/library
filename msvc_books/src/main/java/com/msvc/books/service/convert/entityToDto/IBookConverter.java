package com.msvc.books.service.convert.entityToDto;

import com.msvc.books.dto.BookDto;
import com.msvc.books.model.entity.BookEnt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface IBookConverter<BookEnt, BookDto> extends IGenericConverter<BookEnt, BookDto> {
}
