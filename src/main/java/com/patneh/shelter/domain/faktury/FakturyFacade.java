package com.patneh.shelter.domain.faktury;

import com.patneh.shelter.common.adnotations.Facade;
import com.patneh.shelter.infrasructure.dto.faktury.CreateFakturyDto;
import com.patneh.shelter.infrasructure.dto.faktury.FakturyDto;
import com.patneh.shelter.infrasructure.dto.faktury.UpdateFakturyDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class is facade (access class) to all functionality regarding currencyAccount
 */
@RequiredArgsConstructor
@Facade
public class FakturyFacade {

  private final FakturyService service;

  @Transactional
  public List<FakturyDto> getAllFaktury() {
    return service.getAllFaktury();
  }

  @Transactional
  public List<FakturyDto> getAllFakturyForLecznica(Long lecznicaId) {
    return service.getAllFakturyForLecznica(lecznicaId);
  }
//
//  @Transactional
//  public List<FakturyDto> getAllFakturyForZwierze(Long zwierzeId) {
//    return service.getAllFakturyForZwierze(zwierzeId);
//  }

  @Transactional
  public FakturyDto getFakturaDto(Long id) {
    return service.getFakturaDto(id);
  }

  @Transactional
  public FakturyDto createFaktura(CreateFakturyDto dto) {
    return service.createFaktura(dto);
  }

  @Transactional
  public FakturyDto updateFaktura(UpdateFakturyDto dto) {
    return service.updateFaktura(dto);
  }

  @Transactional
  public void deleteFaktura(Long id) {
    service.deleteFaktura(id);
  }
//
//  public boolean isCurrencyAccountOnDatabase(Long id) {
//    return service.isCurrencyAccountOnDatabase(id);
//  }
//
//  public CurrencyAccountEntity getCurrencyAccount(Long id) {
//    return service.getCurrencyAccount(id);
//  }



}
