package com.patneh.shelter.domain.pracownicy;

import com.patneh.shelter.common.exceptions.PracownicyException;
import com.patneh.shelter.domain.ludzie.LudzieFacade;
import com.patneh.shelter.infrasructure.dto.pracownicy.CreatePracownicyDto;
import com.patneh.shelter.infrasructure.dto.pracownicy.PracownicyDto;
import com.patneh.shelter.infrasructure.dto.pracownicy.UpdatePracownicyDto;
import com.patneh.shelter.infrasructure.entities.PracownicyEntity;
import com.patneh.shelter.infrasructure.enums.StanowiskoEnum;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class PracownicyService {

  private final PracownicyRepository repository;
  private final PracownicyMapper mapper;
  private final LudzieFacade ludzieFacade;

  List<PracownicyDto> getAllPracownicy() {
    return repository.findAll()
        .stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  PracownicyDto getPracownikDto(Long id) {
    return mapToDto(getPracownik(id));
  }

  PracownicyDto createPracownik(CreatePracownicyDto dto) {
    PracownicyEntity entity = mapper.toEntity(dto);
    entity.setCzlowiek(ludzieFacade.getLudzie(dto.getCzlowiekId()));
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  PracownicyDto updatePracownik(UpdatePracownicyDto dto) {
    PracownicyEntity entity = getPracownik(dto.getId());
    entity.setCzlowiek(ludzieFacade.getLudzie(dto.getCzlowiekId()));
    entity.setStanowisko(Enum.valueOf(StanowiskoEnum.class, dto.getStanowisko()));
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  void deletePracownik(Long id) {
    PracownicyEntity entity = getPracownik(id);
//    TODO dodać status
//    entity.setStatus(StatusEnum.INACTIVE);
  }

  PracownicyEntity getPracownik(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> PracownicyException.pracownikNotFound(id));
  }

  private PracownicyDto mapToDto(PracownicyEntity entity) {
    PracownicyDto pracownicyDto = mapper.toDto(entity);
    pracownicyDto.setCzlowiek(ludzieFacade.getLudzieDto(entity.getCzlowiek().getId()));
    return pracownicyDto;
  }
}
