package com.patneh.shelter.infrasructure.dto.ludzie;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateLudzieDto {

 private Long id;
 private String imie;
 private String nazwisko;
 private String email;
 private String telefon;

 @Builder
 UpdateLudzieDto(Long id,
    String imie,
    String nazwisko,
    String email,
    String telefon) {
  this.id = id;
  this.imie= imie;
  this.nazwisko= nazwisko;
  this.email= email;
  this.telefon= telefon;

 }


}
