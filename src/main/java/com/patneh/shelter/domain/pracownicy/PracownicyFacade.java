package com.patneh.shelter.domain.pracownicy;

import com.patneh.shelter.common.adnotations.Facade;
import com.patneh.shelter.infrasructure.dto.pracownicy.CreatePracownicyDto;
import com.patneh.shelter.infrasructure.dto.pracownicy.PracownicyDto;
import com.patneh.shelter.infrasructure.dto.pracownicy.UpdatePracownicyDto;
import com.patneh.shelter.infrasructure.entities.PracownicyEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class is facade (access class) to all functionality regarding currencyAccount
 */
@RequiredArgsConstructor
@Facade
public class PracownicyFacade {

  private final PracownicyService service;

  @Transactional
  public List<PracownicyDto> getAllPracownicy() {
    return service.getAllPracownicy();
  }

  @Transactional
  public PracownicyDto getPracownikDto(Long id) {
    return service.getPracownikDto(id);
  }

  @Transactional
  public PracownicyDto createPracownik(CreatePracownicyDto dto) {
    return service.createPracownik(dto);
  }

  @Transactional
  public PracownicyDto updatePracownik(UpdatePracownicyDto dto) {
    return service.updatePracownik(dto);
  }

  @Transactional
  public void deletePracownik(Long id) {
    service.deletePracownik(id);
  }

  public PracownicyEntity getPracownik(Long id) {
    return service.getPracownik(id);
  }



}
