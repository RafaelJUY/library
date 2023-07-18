package com.msvc.books.service.convert.entityToDto.impl;

import com.msvc.books.dto.AuthorDto;
import com.msvc.books.model.entity.AuthorEnt;
import com.msvc.books.service.convert.entityToDto.IAuthorConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AuthorConverterImpl implements IAuthorConverter<AuthorEnt, AuthorDto> {


    @Autowired
    private ModelMapper mapper;

    @Override
    public AuthorDto entityToDto(AuthorEnt authorEnt) {
        return mapper.map(authorEnt, AuthorDto.class);
    }

    @Override
    public AuthorEnt dtoToEntity(AuthorDto authorDto) {
        return mapper.map(authorDto, AuthorEnt.class);
    }
}
