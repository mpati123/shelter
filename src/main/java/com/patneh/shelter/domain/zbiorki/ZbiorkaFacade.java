package com.patneh.shelter.domain.zbiorki;

import com.patneh.shelter.common.adnotations.Facade;
import com.patneh.shelter.infrasructure.dto.zbiorka.CreateZbiorkaDto;
import com.patneh.shelter.infrasructure.dto.zbiorka.UpdateZbiorkaDto;
import com.patneh.shelter.infrasructure.dto.zbiorka.ZbiorkaDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class is facade (access class) to all functionality regarding currencyAccount
 */
@RequiredArgsConstructor
@Facade
public class ZbiorkaFacade {

  private final ZbiorkaService service;

  @Transactional
  public List<ZbiorkaDto> getAllZbiorki() {
    return service.getAllZbiorki();
  }

  @Transactional
  public ZbiorkaDto getZbiorkaDto(Long id) {
    return service.getZbiorkaDto(id);
  }

  @Transactional
  public ZbiorkaDto createZbiorka(CreateZbiorkaDto dto) {
    return service.createZbiorka(dto);
  }

  @Transactional
  public ZbiorkaDto updateZbiorka(UpdateZbiorkaDto dto) {
    return service.updateZbiorka(dto);
  }

  @Transactional
  public void deleteZbiorka(Long id) {
    service.deleteZbiorka(id);
  }



}
