package com.msvc.books.service.convert.entityToDto;

import java.util.List;
import java.util.stream.Collectors;

public interface IGenericConverter<ENT, DTO> {
    DTO entityToDto(ENT ent);
    ENT dtoToEntity(DTO dto);
    default List<ENT> dtoListToEntityList(List<DTO> dtoList){
        List<ENT> entList = dtoList.stream()
                                         .map(dto -> dtoToEntity(dto))
                                         .collect(Collectors.toList());
        return entList;
    }
    default List<DTO> entityListToDtoList(List<ENT> entList){
        List<DTO> dtoList = entList.stream()
                                        .map(ent -> entityToDto(ent))
                                        .collect(Collectors.toList());
        return dtoList;
    }
}
