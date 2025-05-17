package com.patneh.shelter.domain.zwierzeta;


import com.patneh.shelter.infrasructure.dto.zwierzeta.CreateZwierzetaDto;
import com.patneh.shelter.infrasructure.dto.zwierzeta.UpdateZwierzetaDto;
import com.patneh.shelter.infrasructure.dto.zwierzeta.ZwierzetaDto;
import com.patneh.shelter.infrasructure.entities.ZwierzetaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface ZwierzetaMapper {

  @Mapping(target = "gatunek", ignore = true)
  @Mapping(target = "opiekun", ignore = true)
  ZwierzetaEntity toEntity(CreateZwierzetaDto dto);
  @Mapping(target = "gatunek", ignore = true)
  @Mapping(target = "opiekun", ignore = true)
  ZwierzetaEntity toEntity(UpdateZwierzetaDto dto);

  @Mapping(target = "gatunek", ignore = true)
  @Mapping(target = "opiekun", ignore = true)
  ZwierzetaDto toDto(ZwierzetaEntity entity);


}
