package com.msvc.books.service.convert.entityToDto;

import com.msvc.books.dto.BookDto;
import com.msvc.books.model.entity.BookEnt;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BookConverter {
    //@Autowired
    private static ModelMapper mapper = new ModelMapper();

    public static BookDto entityToDto(BookEnt bookEnt) {
        return mapper.map(bookEnt, BookDto.class);
    }


    public static BookEnt dtoToEntity(BookDto bookDto) {
        return mapper.map(bookDto, BookEnt.class);
    }


    public static List<BookEnt> dtoListToEntityList(List<BookDto> dtoList) {
        return dtoList.stream()
                .map(dto -> dtoToEntity(dto))
                .collect(Collectors.toList());
    }


    public static List<BookDto> entityListToDtoList(List<BookEnt> entList) {
        return entList.stream()
                .map(ent -> entityToDto(ent))
                .collect(Collectors.toList());
    }
}
