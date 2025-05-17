package com.patneh.shelter.domain.gatunki;


import com.patneh.shelter.infrasructure.dto.gatunek.CreateGatunekDto;
import com.patneh.shelter.infrasructure.dto.gatunek.GatunekDto;
import com.patneh.shelter.infrasructure.dto.gatunek.UpdateGatunekDto;
import com.patneh.shelter.infrasructure.entities.GatunekEntity;
import org.mapstruct.Mapper;

@Mapper
interface GatunekMapper {

  GatunekEntity toEntity(CreateGatunekDto dto);
  GatunekEntity toEntity(UpdateGatunekDto dto);

  GatunekDto toDto(GatunekEntity entity);


}
