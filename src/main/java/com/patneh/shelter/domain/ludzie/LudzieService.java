package com.patneh.shelter.domain.ludzie;

import com.patneh.shelter.common.exceptions.PracownicyException;
import com.patneh.shelter.infrasructure.dto.ludzie.CreateLudzieDto;
import com.patneh.shelter.infrasructure.dto.ludzie.LudzieDto;
import com.patneh.shelter.infrasructure.dto.ludzie.UpdateLudzieDto;
import com.patneh.shelter.infrasructure.entities.LudzieEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class LudzieService {

  private final LudzieRepository repository;
  private final LudzieMapper mapper;

  List<LudzieDto> getAllLudzie() {
    return repository.findAll()
        .stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  LudzieDto getLudzieDto(Long id) {
    return mapToDto(getLudzie(id));
  }

  LudzieDto createLudzie(CreateLudzieDto dto) {
    LudzieEntity entity = mapper.toEntity(dto);
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  LudzieDto updateLudzie(UpdateLudzieDto dto) {
    LudzieEntity entity = getLudzie(dto.getId());
    entity.setImie(dto.getImie());
    entity.setNazwisko(dto.getNazwisko());
    entity.setEmail(dto.getEmail());
    entity.setTelefon(dto.getTelefon());
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  void deleteLudzie(Long id) {
    LudzieEntity entity = getLudzie(id);
//    TODO dodać status
//    entity.setStatus(StatusEnum.INACTIVE);
  }

  LudzieEntity getLudzie(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> PracownicyException.pracownikNotFound(id));
  }

  private LudzieDto mapToDto(LudzieEntity entity) {
    LudzieDto ludzieDto = mapper.toDto(entity);
    return ludzieDto;
  }
}
