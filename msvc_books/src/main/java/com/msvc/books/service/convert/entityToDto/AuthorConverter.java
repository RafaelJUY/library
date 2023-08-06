package com.msvc.books.service.convert.entityToDto;

import com.msvc.books.dto.AuthorDto;
import com.msvc.books.model.entity.AuthorEnt;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorConverter {
    private static ModelMapper mapper = new ModelMapper();

    //@Override
    public static AuthorDto entityToDto(AuthorEnt authorEnt) {
        return mapper.map(authorEnt, AuthorDto.class);
    }

    //@Override
    public static AuthorEnt dtoToEntity(AuthorDto authorDto) {
        return mapper.map(authorDto, AuthorEnt.class);
    }

    public static List<AuthorEnt> dtoListToEntityList(List<AuthorDto> dtoList) {
        return dtoList.stream()
                .map(dto -> dtoToEntity(dto))
                .collect(Collectors.toList());
    }


    public static List<AuthorDto> entityListToDtoList(List<AuthorEnt> entList) {
        return entList.stream()
                .map(ent -> entityToDto(ent))
                .collect(Collectors.toList());
    }
}
