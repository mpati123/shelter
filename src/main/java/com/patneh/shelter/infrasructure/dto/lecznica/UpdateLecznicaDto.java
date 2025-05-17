package com.patneh.shelter.infrasructure.dto.lecznica;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateLecznicaDto {

 private Long id;
 private String nazwa;
 private String adres;
 private String telefon;

 @Builder
 UpdateLecznicaDto(Long id,
    String nazwa,
    String adres,
    String telefon) {
  this.id = id;
  this.nazwa = nazwa;
  this.adres = adres;
  this.telefon = telefon;
 }


}
