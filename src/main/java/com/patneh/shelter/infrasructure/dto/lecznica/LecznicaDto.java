package com.patneh.shelter.infrasructure.dto.lecznica;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LecznicaDto {

 private Long id;
 private UUID uuid;
 private String nazwa;
 private String adres;
 private String telefon;

 @Builder
 LecznicaDto(Long id,
    UUID uuid,
    String nazwa,
    String adres,
    String telefon) {
  this.id = id;
  this.uuid = uuid;
  this.nazwa = nazwa;
  this.adres = adres;
  this.telefon = telefon;
 }


}
