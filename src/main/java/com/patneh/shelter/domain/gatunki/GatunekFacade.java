package com.patneh.shelter.domain.gatunki;

import com.patneh.shelter.common.adnotations.Facade;
import com.patneh.shelter.infrasructure.dto.gatunek.CreateGatunekDto;
import com.patneh.shelter.infrasructure.dto.gatunek.GatunekDto;
import com.patneh.shelter.infrasructure.dto.gatunek.UpdateGatunekDto;
import com.patneh.shelter.infrasructure.entities.GatunekEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class is facade (access class) to all functionality regarding currencyAccount
 */
@RequiredArgsConstructor
@Facade
public class GatunekFacade {

  private final GatunekService service;

  @Transactional
  public List<GatunekDto> getAllGatunki() {
    return service.getAllGatunki();
  }

  @Transactional
  public GatunekDto getGatunekDto(Long id) {
    return service.getGatunekDto(id);
  }

  @Transactional
  public GatunekDto createGatunek(CreateGatunekDto dto) {
    return service.createGatunek(dto);
  }

  @Transactional
  public GatunekDto updateGatunek(UpdateGatunekDto dto) {
    return service.updateGatunek(dto);
  }

  @Transactional
  public void deleteGatunek(Long id) {
    service.deleteGatunek(id);
  }

  public GatunekEntity getGatunekEntity(Long id) {
    return service.getGatunek(id);
  }

}
