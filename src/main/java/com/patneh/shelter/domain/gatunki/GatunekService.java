package com.patneh.shelter.domain.gatunki;

import com.patneh.shelter.common.exceptions.GatunekException;
import com.patneh.shelter.infrasructure.dto.gatunek.CreateGatunekDto;
import com.patneh.shelter.infrasructure.dto.gatunek.GatunekDto;
import com.patneh.shelter.infrasructure.dto.gatunek.UpdateGatunekDto;
import com.patneh.shelter.infrasructure.entities.GatunekEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class GatunekService {

  private final GatunekRepository repository;
  private final GatunekMapper mapper;

  List<GatunekDto> getAllGatunki() {
    return repository.findAll()
        .stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  GatunekDto getGatunekDto(Long id) {
    return mapToDto(getGatunek(id));
  }

  GatunekDto createGatunek(CreateGatunekDto dto) {
    GatunekEntity entity = mapper.toEntity(dto);
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  GatunekDto updateGatunek(UpdateGatunekDto dto) {
    GatunekEntity entity = getGatunek(dto.getId());
    entity.setNazwa(dto.getNazwa());
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  void deleteGatunek(Long id) {
    GatunekEntity entity = getGatunek(id);
//    TODO dodać status
//    entity.setStatus(StatusEnum.INACTIVE);
  }

  GatunekEntity getGatunek(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> GatunekException.gatunekNotFound(id));
  }

  private GatunekDto mapToDto(GatunekEntity entity) {
    GatunekDto gatunekDto = mapper.toDto(entity);
    return gatunekDto;
  }
}
