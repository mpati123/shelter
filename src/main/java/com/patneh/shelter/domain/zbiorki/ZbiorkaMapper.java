package com.patneh.shelter.domain.zbiorki;


import com.patneh.shelter.infrasructure.dto.zbiorka.CreateZbiorkaDto;
import com.patneh.shelter.infrasructure.dto.zbiorka.UpdateZbiorkaDto;
import com.patneh.shelter.infrasructure.dto.zbiorka.ZbiorkaDto;
import com.patneh.shelter.infrasructure.entities.ZbiorkaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface ZbiorkaMapper {

  @Mapping(target = "zwierzeta", ignore = true)
  ZbiorkaEntity toEntity(CreateZbiorkaDto dto);
  @Mapping(target = "zwierzeta", ignore = true)
  ZbiorkaEntity toEntity(UpdateZbiorkaDto dto);

  @Mapping(target = "zwierzeta", ignore = true)
  ZbiorkaDto toDto(ZbiorkaEntity entity);


}
