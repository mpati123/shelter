package com.patneh.shelter.infrasructure.dto.gatunek;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateGatunekDto {

 private String nazwa;

 @Builder
 CreateGatunekDto(Long id,
    UUID uuid,
    String nazwa) {
  this.nazwa = nazwa;

 }


}
