package com.patneh.shelter.domain.ludzie;


import com.patneh.shelter.infrasructure.dto.ludzie.CreateLudzieDto;
import com.patneh.shelter.infrasructure.dto.ludzie.LudzieDto;
import com.patneh.shelter.infrasructure.dto.ludzie.UpdateLudzieDto;
import com.patneh.shelter.infrasructure.entities.LudzieEntity;
import org.mapstruct.Mapper;

@Mapper
interface LudzieMapper {

  LudzieEntity toEntity(CreateLudzieDto dto);
  LudzieEntity toEntity(UpdateLudzieDto dto);

  LudzieDto toDto(LudzieEntity entity);


}
