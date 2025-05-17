package com.patneh.shelter.infrasructure.dto.zwierzeta;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateZwierzetaDto {

 private String imie;
 private Long gatunekId;
 private Long opiekunId;
 private Integer wiek;
 private String stan;
 private String miejsce;


 @Builder
 CreateZwierzetaDto(
     String imie,
     Long gatunekId,
     Long opiekunId,
     Integer wiek,
     String stan,
     String miejsce) {
  this.imie = imie;
  this.gatunekId = gatunekId;
  this.opiekunId = opiekunId;
  this.wiek = wiek;
  this.stan = stan;
  this.miejsce = miejsce;

 }


}
