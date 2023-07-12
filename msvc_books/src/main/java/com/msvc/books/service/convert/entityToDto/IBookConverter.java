package com.msvc.books.service.convert.entityToDto;

import com.msvc.books.dto.BookDto;
import com.msvc.books.model.entity.BookEnt;

public interface IBookConverter<BookEnt, BookDto> extends IGenericConverter<BookEnt, BookDto> {
}
