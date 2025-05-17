package com.patneh.shelter.domain.faktury;

import com.patneh.shelter.common.exceptions.FakturaException;
import com.patneh.shelter.domain.lecznice.LecznicaFacade;
import com.patneh.shelter.domain.zwierzeta.ZwierzetaFacade;
import com.patneh.shelter.infrasructure.dto.faktury.CreateFakturyDto;
import com.patneh.shelter.infrasructure.dto.faktury.FakturyDto;
import com.patneh.shelter.infrasructure.dto.faktury.UpdateFakturyDto;
import com.patneh.shelter.infrasructure.entities.FakturyEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class FakturyService {

  private final FakturyRepository repository;
  private final FakturyMapper mapper;
  private final LecznicaFacade lecznicaFacade;
  private final ZwierzetaFacade zwierzetaFacade;

  List<FakturyDto> getAllFaktury() {
    return repository.findAll()
        .stream()
//        .filter(object -> object.getStatus().equals(StatusEnum.ACTIVE))
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  List<FakturyDto> getAllFakturyForLecznica(Long lecznicaId) {
    return repository.findAllByLecznicaId(lecznicaId)
        .stream()
//        .filter(object -> object.getStatus().equals(StatusEnum.ACTIVE))
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

//  TODO Zroić fakturę per zwierzę

//  List<FakturyDto> getAllFakturyForZwierze(Long zwierzeId) {
//    return repository.findAll(userId)
//        .stream()
//        .filter(account -> account.getStatus().equals(StatusEnum.ACTIVE))
//        .map(this::mapToDto)
//        .collect(Collectors.toList());
//  }

  FakturyDto getFakturaDto(Long id) {
    return mapToDto(getFaktura(id));
  }

  private FakturyEntity getFaktura(Long id) {
    return repository.findById(id)
//        .filter(object -> object.getStatus().equals(StatusEnum.ACTIVE))
        .orElseThrow(() -> FakturaException.fakturaNotFound(id));
    }

  FakturyDto createFaktura(CreateFakturyDto dto) {
    FakturyEntity entity = mapper.toEntity(dto);
    entity.setLecznica(lecznicaFacade.getLecznica(dto.getLecznicaId()));
    entity.setZwierzeta(dto.getZwierzeta()
        .stream()
        .map(zwierzetaFacade::getZwierze)
        .collect(Collectors.toSet()));//    entity.setStatus(StatusEnum.ACTIVE);
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  FakturyDto updateFaktura(UpdateFakturyDto dto) {
    FakturyEntity entity = getFaktura(dto.getId());
    entity.setData(dto.getData());
    entity.setKwota(dto.getKwota());
    entity.setNumer(dto.getNumer());
    entity.setZwierzeta(dto.getZwierzeta()
        .stream()
        .map(zwierzetaFacade::getZwierze)
        .collect(Collectors.toSet()));    entity.setLecznica(lecznicaFacade.getLecznica(dto.getLecznicaId()));
    repository.saveAndFlush(entity);
    return mapToDto(entity);
  }

  void deleteFaktura(Long id) {
    FakturyEntity entity = getFaktura(id);
//    TODO Pododawać wszędzie statusy
//    entity.setStatus(StatusEnum.INACTIVE);
  }

  private FakturyDto mapToDto(FakturyEntity entity) {
    FakturyDto fakturyDto = mapper.toDto(entity);
    fakturyDto.setZwierzeta(entity.getZwierzeta()
        .stream()
        .map(zwierze -> zwierzetaFacade.getZwierzeDto(zwierze.getId()))
        .collect(Collectors.toSet()));
    fakturyDto.setLecznica(lecznicaFacade.getLecznicaDto(entity.getLecznica().getId()));
    return fakturyDto;
  }

}
