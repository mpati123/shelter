package com.patneh.shelter.domain.lecznice;

import com.patneh.shelter.common.adnotations.Facade;
import com.patneh.shelter.infrasructure.dto.lecznica.CreateLecznicaDto;
import com.patneh.shelter.infrasructure.dto.lecznica.LecznicaDto;
import com.patneh.shelter.infrasructure.dto.lecznica.UpdateLecznicaDto;
import com.patneh.shelter.infrasructure.entities.LecznicaEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class is facade (access class) to all functionality regarding currencyAccount
 */
@RequiredArgsConstructor
@Facade
public class LecznicaFacade {

  private final LecznicaService service;

  @Transactional
  public List<LecznicaDto> getAllLecznice() {
    return service.getAllLecznice();
  }

  @Transactional
  public LecznicaDto getLecznicaDto(Long id) {
    return service.getLecznicaDto(id);
  }

  @Transactional
  public LecznicaDto createLecznica(CreateLecznicaDto dto) {
    return service.createLecznica(dto);
  }

  @Transactional
  public LecznicaDto updateLecznica(UpdateLecznicaDto dto) {
    return service.updateLecznica(dto);
  }

  @Transactional
  public void deleteLecznica(Long id) {
    service.deleteLecznica(id);
  }

  public LecznicaEntity getLecznica(Long id) {
    return service.getLecznica(id);
  }



}
