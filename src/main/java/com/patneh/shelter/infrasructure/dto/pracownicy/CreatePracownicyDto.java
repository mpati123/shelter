package com.patneh.shelter.infrasructure.dto.pracownicy;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePracownicyDto {

 private Long czlowiekId;
 private String stanowisko;

 @Builder
 CreatePracownicyDto(
     Long czlowiekId,
     String stanowisko
    ) {
  this.czlowiekId = czlowiekId;
  this.stanowisko = stanowisko;

 }


}
