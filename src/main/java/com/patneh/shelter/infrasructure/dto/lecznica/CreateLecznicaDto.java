package com.patneh.shelter.infrasructure.dto.lecznica;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateLecznicaDto {

 private String nazwa;
 private String adres;
 private String telefon;

 @Builder
 CreateLecznicaDto(String nazwa,
    String adres,
    String telefon) {
  this.nazwa = nazwa;
  this.adres = adres;
  this.telefon = telefon;
 }


}
