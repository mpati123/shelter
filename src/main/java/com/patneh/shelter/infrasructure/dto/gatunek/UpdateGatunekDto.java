package com.patneh.shelter.infrasructure.dto.gatunek;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateGatunekDto {

 private Long id;
 private String nazwa;

 @Builder
 UpdateGatunekDto(Long id,
    String nazwa) {
  this.id = id;
  this.nazwa = nazwa;

 }


}
