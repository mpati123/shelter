package com.patneh.shelter.domain.zwierzeta;

import com.patneh.shelter.common.exceptions.ZwierzetaException;
import com.patneh.shelter.domain.gatunki.GatunekFacade;
import com.patneh.shelter.domain.pracownicy.PracownicyFacade;
import com.patneh.shelter.infrasructure.dto.zwierzeta.CreateZwierzetaDto;
import com.patneh.shelter.infrasructure.dto.zwierzeta.UpdateZwierzetaDto;
import com.patneh.shelter.infrasructure.dto.zwierzeta.ZwierzetaDto;
import com.patneh.shelter.infrasructure.entities.ZwierzetaEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class ZwierzetaService {

  private final ZwierzetaRepository repository;
  private final ZwierzetaMapper mapper;
  private final GatunekFacade gatunekFacade;
  private final PracownicyFacade pracownicyFacade;

  List<ZwierzetaDto> getAllZwierzeta() {
    return repository.findAll()
        .stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  ZwierzetaDto getZwierzeDto(Long id) {
    return mapToDto(getZwierze(id));
  }

  ZwierzetaDto createZwierze(CreateZwierzetaDto dto) {
    ZwierzetaEntity entity = mapper.toEntity(dto);
    entity.setOpiekun(pracownicyFacade.getPracownik(dto.getOpiekunId()));
    entity.setGatunek(gatunekFacade.getGatunekEntity(dto.getGatunekId()));
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  ZwierzetaDto updateZwierze(UpdateZwierzetaDto dto) {
    ZwierzetaEntity entity = getZwierze(dto.getId());
    entity.setImie(dto.getImie());
    entity.setWiek(dto.getWiek());
    entity.setGatunek(gatunekFacade.getGatunekEntity(dto.getGatunekId()));
    entity.setOpiekun(pracownicyFacade.getPracownik(dto.getOpiekunId()));
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  void deleteZwierzeta(Long id) {
    ZwierzetaEntity entity = getZwierze(id);
//    TODO dodać status
//    entity.setStatus(StatusEnum.INACTIVE);
  }

  ZwierzetaEntity getZwierze(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> ZwierzetaException.zwierzeNotFound(id));
  }

  private ZwierzetaDto mapToDto(ZwierzetaEntity entity) {
    ZwierzetaDto zwierzetaDto = mapper.toDto(entity);
    zwierzetaDto.setOpiekun(pracownicyFacade.getPracownikDto(entity.getOpiekun().getId()));
    zwierzetaDto.setGatunek(gatunekFacade.getGatunekDto(entity.getGatunek().getId()));
    return zwierzetaDto;
  }
}
