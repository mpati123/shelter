package com.patneh.shelter.domain.lecznice;


import com.patneh.shelter.infrasructure.dto.lecznica.CreateLecznicaDto;
import com.patneh.shelter.infrasructure.dto.lecznica.LecznicaDto;
import com.patneh.shelter.infrasructure.dto.lecznica.UpdateLecznicaDto;
import com.patneh.shelter.infrasructure.entities.LecznicaEntity;
import org.mapstruct.Mapper;

@Mapper
interface LecznicaMapper {

  LecznicaEntity toEntity(CreateLecznicaDto dto);
  LecznicaEntity toEntity(UpdateLecznicaDto dto);

  LecznicaDto toDto(LecznicaEntity entity);


}
