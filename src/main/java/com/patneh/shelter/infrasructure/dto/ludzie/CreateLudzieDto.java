package com.patneh.shelter.infrasructure.dto.ludzie;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateLudzieDto {

 private String imie;
 private String nazwisko;
 private String email;
 private String telefon;

 @Builder
 CreateLudzieDto(String imie,
    String nazwisko,
    String email,
    String telefon) {
  this.imie= imie;
  this.nazwisko= nazwisko;
  this.email= email;
  this.telefon= telefon;

 }


}
