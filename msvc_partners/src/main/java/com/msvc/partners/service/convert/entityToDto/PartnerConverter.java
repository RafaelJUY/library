package com.msvc.partners.service.convert.entityToDto;

import com.msvc.partners.dto.PartnerDto;
import com.msvc.partners.model.entity.PartnerEnt;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PartnerConverter {
    public static ModelMapper mapper = new ModelMapper();

    public static PartnerDto entityToDto(PartnerEnt ent){
        return mapper.map(ent, PartnerDto.class);
    }
    public static PartnerEnt dtoToEntity(PartnerDto dto){
        return mapper.map(dto, PartnerEnt.class);
    }

    public static List<PartnerDto> entityListToDtoList(List<PartnerEnt> entList){
        return entList.stream().map(PartnerConverter::entityToDto).collect(Collectors.toList());
    }

    public static List<PartnerEnt> dtoListToEntityList(List<PartnerDto> dtoList){
        return dtoList.stream().map(PartnerConverter::dtoToEntity).collect(Collectors.toList());
    }
}
