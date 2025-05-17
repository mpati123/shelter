package com.patneh.shelter.domain.pracownicy;


import com.patneh.shelter.infrasructure.dto.pracownicy.CreatePracownicyDto;
import com.patneh.shelter.infrasructure.dto.pracownicy.PracownicyDto;
import com.patneh.shelter.infrasructure.dto.pracownicy.UpdatePracownicyDto;
import com.patneh.shelter.infrasructure.entities.PracownicyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface PracownicyMapper {

  @Mapping(target = "czlowiek", ignore = true)
  PracownicyEntity toEntity(CreatePracownicyDto dto);

  @Mapping(target = "czlowiek", ignore = true)
  PracownicyEntity toEntity(UpdatePracownicyDto dto);

  @Mapping(target = "czlowiek", ignore = true)
  PracownicyDto toDto(PracownicyEntity entity);

}
