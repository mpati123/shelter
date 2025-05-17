package com.patneh.shelter.domain.zwierzeta;

import com.patneh.shelter.common.adnotations.Facade;
import com.patneh.shelter.infrasructure.dto.zwierzeta.CreateZwierzetaDto;
import com.patneh.shelter.infrasructure.dto.zwierzeta.UpdateZwierzetaDto;
import com.patneh.shelter.infrasructure.dto.zwierzeta.ZwierzetaDto;
import com.patneh.shelter.infrasructure.entities.ZwierzetaEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class is facade (access class) to all functionality regarding currencyAccount
 */
@RequiredArgsConstructor
@Facade
public class ZwierzetaFacade {

  private final ZwierzetaService service;

  @Transactional
  public List<ZwierzetaDto> getAllZwierzeta() {
    return service.getAllZwierzeta();
  }

  @Transactional
  public ZwierzetaDto getZwierzeDto(Long id) {
    return service.getZwierzeDto(id);
  }

  @Transactional
  public ZwierzetaDto createZwierze(CreateZwierzetaDto dto) {
    return service.createZwierze(dto);
  }

  @Transactional
  public ZwierzetaDto updateZwierze(UpdateZwierzetaDto dto) {
    return service.updateZwierze(dto);
  }

  @Transactional
  public void deleteZwierzeta(Long id) {
    service.deleteZwierzeta(id);
  }

  public ZwierzetaEntity getZwierze(Long id) {
    return service.getZwierze(id);
  }


}
