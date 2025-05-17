package com.patneh.shelter.infrasructure.dto.zwierzeta;

import com.patneh.shelter.infrasructure.dto.gatunek.GatunekDto;
import com.patneh.shelter.infrasructure.dto.pracownicy.PracownicyDto;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ZwierzetaDto {

 private Long id;
 private UUID uuid;
 private String imie;
 private GatunekDto gatunek;
 private PracownicyDto opiekun;
 private Integer wiek;
 private String stan;
 private String miejsce;

 @Builder
 ZwierzetaDto(Long id,
     UUID uuid,
     String imie,
     GatunekDto gatunek,
     PracownicyDto opiekun,
     Integer wiek,
    String stan,
    String miejsce) {
  this.id = id;
  this.uuid = uuid;
  this.imie = imie;
  this.gatunek = gatunek;
  this.opiekun = opiekun;
  this.wiek = wiek;
  this.stan = stan;
  this.miejsce = miejsce;

 }


}
