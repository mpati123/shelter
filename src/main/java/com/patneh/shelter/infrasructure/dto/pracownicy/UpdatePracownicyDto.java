package com.patneh.shelter.infrasructure.dto.pracownicy;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdatePracownicyDto {

 private Long id;
 private Long czlowiekId;
 private String stanowisko;

 @Builder
 UpdatePracownicyDto(Long id,
     Long czlowiekId,
    String stanowisko
    ) {
  this.id = id;
  this.czlowiekId = czlowiekId;
  this.stanowisko = stanowisko;

 }


}
