package com.patneh.shelter.domain.ludzie;

import com.patneh.shelter.common.adnotations.Facade;
import com.patneh.shelter.infrasructure.dto.ludzie.CreateLudzieDto;
import com.patneh.shelter.infrasructure.dto.ludzie.LudzieDto;
import com.patneh.shelter.infrasructure.dto.ludzie.UpdateLudzieDto;
import com.patneh.shelter.infrasructure.entities.LudzieEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class is facade (access class) to all functionality regarding currencyAccount
 */
@RequiredArgsConstructor
@Facade
public class LudzieFacade {

  private final LudzieService service;

  @Transactional
  public List<LudzieDto> getAllLudzie() {
    return service.getAllLudzie();
  }

  @Transactional
  public LudzieDto getLudzieDto(Long id) {
    return service.getLudzieDto(id);
  }

  @Transactional
  public LudzieDto createLudzie(CreateLudzieDto dto) {
    return service.createLudzie(dto);
  }

  @Transactional
  public LudzieDto updateLudzie(UpdateLudzieDto dto) {
    return service.updateLudzie(dto);
  }

  @Transactional
  public void deleteLudzie(Long id) {
    service.deleteLudzie(id);
  }

  public LudzieEntity getLudzie(Long id) {
    return service.getLudzie(id);
  }



}
