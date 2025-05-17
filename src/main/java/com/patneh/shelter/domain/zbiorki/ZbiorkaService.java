package com.patneh.shelter.domain.zbiorki;

import com.patneh.shelter.common.exceptions.ZbiorkaException;
import com.patneh.shelter.domain.zwierzeta.ZwierzetaFacade;
import com.patneh.shelter.infrasructure.dto.zbiorka.CreateZbiorkaDto;
import com.patneh.shelter.infrasructure.dto.zbiorka.UpdateZbiorkaDto;
import com.patneh.shelter.infrasructure.dto.zbiorka.ZbiorkaDto;
import com.patneh.shelter.infrasructure.entities.ZbiorkaEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class ZbiorkaService {

  private final ZbiorkaRepository repository;
  private final ZbiorkaMapper mapper;
  private final ZwierzetaFacade zwierzetaFacade;

    List<ZbiorkaDto> getAllZbiorki() {
      return repository.findAll()
          .stream()
          .map(this::mapToDto)
          .collect(Collectors.toList());
    }

  ZbiorkaDto getZbiorkaDto(Long id) {
      return mapToDto(getZbiorka(id));
    }

  ZbiorkaDto createZbiorka(CreateZbiorkaDto dto) {
    ZbiorkaEntity entity = mapper.toEntity(dto);
    entity.setZwierzeta(dto.getZwierzeta()
        .stream()
        .map(zwierzetaFacade::getZwierze)
        .collect(Collectors.toSet()));
      repository.saveAndFlush(entity);
      return mapToDto(entity);
    }

  ZbiorkaDto updateZbiorka(UpdateZbiorkaDto dto) {
    ZbiorkaEntity entity = getZbiorka(dto.getId());
      entity.setNazwa(dto.getNazwa());
      entity.setCel(dto.getCel());
      entity.setKwotaDocelowa(dto.getKwotaDocelowa());
      entity.setKwotaZebrana(dto.getKwotaZebrana());
      entity.setZwierzeta(dto.getZwierzeta()
        .stream()
        .map(zwierzetaFacade::getZwierze)
        .collect(Collectors.toSet()));
      repository.saveAndFlush(entity);
      return mapToDto(entity);
    }

    void deleteZbiorka(Long id) {
      ZbiorkaEntity entity = getZbiorka(id);
  //    TODO dodać status
  //    entity.setStatus(StatusEnum.INACTIVE);
    }

    private ZbiorkaEntity getZbiorka(Long id) {
      return repository.findById(id)
          .orElseThrow(() -> ZbiorkaException.zbiorkaNotFound(id));
    }

    private ZbiorkaDto mapToDto(ZbiorkaEntity entity) {
      ZbiorkaDto zbiorkaDto = mapper.toDto(entity);
      zbiorkaDto.setZwierzeta(entity.getZwierzeta()
          .stream()
          .map(zwierze -> zwierzetaFacade.getZwierzeDto(zwierze.getId()))
          .collect(Collectors.toSet()));
      return zbiorkaDto;
    }
}
