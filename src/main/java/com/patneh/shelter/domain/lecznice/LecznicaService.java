package com.patneh.shelter.domain.lecznice;

import com.patneh.shelter.common.exceptions.LecznicaException;
import com.patneh.shelter.infrasructure.dto.lecznica.CreateLecznicaDto;
import com.patneh.shelter.infrasructure.dto.lecznica.LecznicaDto;
import com.patneh.shelter.infrasructure.dto.lecznica.UpdateLecznicaDto;
import com.patneh.shelter.infrasructure.entities.LecznicaEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class LecznicaService {

  private final LecznicaRepository repository;
  private final LecznicaMapper mapper;

  List<LecznicaDto> getAllLecznice() {
    return repository.findAll()
        .stream()
//        .filter(object -> object.getStatus().equals(StatusEnum.ACTIVE))
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  LecznicaDto getLecznicaDto(Long id) {
    return mapToDto(getLecznica(id));
  }

  LecznicaDto createLecznica(CreateLecznicaDto dto) {
    LecznicaEntity entity = mapper.toEntity(dto);
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  LecznicaDto updateLecznica(UpdateLecznicaDto dto) {
    LecznicaEntity entity = getLecznica(dto.getId());
    entity.setNazwa(dto.getNazwa());
    entity.setAdres(dto.getAdres());
    entity.setTelefon(dto.getTelefon());
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  void deleteLecznica(Long id) {
    LecznicaEntity entity = getLecznica(id);
//    TODO dodać status
//    entity.setStatus(StatusEnum.INACTIVE);
  }

  LecznicaEntity getLecznica(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> LecznicaException.lecznicaNotFound(id));
  }

  private LecznicaDto mapToDto(LecznicaEntity entity) {
    LecznicaDto lecznicaDto = mapper.toDto(entity);
    return lecznicaDto;
  }

  private boolean isLecznicaOnDatabase(Long id) {
    return repository.findById(id)
        .isPresent();
  }
}
