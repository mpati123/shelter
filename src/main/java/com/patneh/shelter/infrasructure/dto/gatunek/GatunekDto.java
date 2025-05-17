package com.patneh.shelter.infrasructure.dto.gatunek;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GatunekDto {

 private Long id;
 private UUID uuid;
 private String nazwa;

 @Builder
 GatunekDto(Long id,
    UUID uuid,
    String nazwa) {
  this.id = id;
  this.uuid = uuid;
  this.nazwa = nazwa;

 }


}
