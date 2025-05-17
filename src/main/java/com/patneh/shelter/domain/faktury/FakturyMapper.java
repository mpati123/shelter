package com.patneh.shelter.domain.faktury;


import com.patneh.shelter.infrasructure.dto.faktury.CreateFakturyDto;
import com.patneh.shelter.infrasructure.dto.faktury.FakturyDto;
import com.patneh.shelter.infrasructure.dto.faktury.UpdateFakturyDto;
import com.patneh.shelter.infrasructure.entities.FakturyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface FakturyMapper {

  @Mapping(target = "lecznica", ignore = true)
  @Mapping(target = "zwierzeta", ignore = true)
  FakturyEntity toEntity(CreateFakturyDto dto);
  @Mapping(target = "lecznica", ignore = true)
  @Mapping(target = "zwierzeta", ignore = true)
  FakturyEntity toEntity(UpdateFakturyDto dto);

  @Mapping(target = "lecznica", ignore = true)
  @Mapping(target = "zwierzeta", ignore = true)
  FakturyDto toDto(FakturyEntity entity);


}
