package com.patneh.shelter.infrasructure.dto.pracownicy;

import com.patneh.shelter.infrasructure.dto.ludzie.LudzieDto;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PracownicyDto {

 private Long id;
 private UUID uuid;
 private LudzieDto czlowiek;
 private String stanowisko;

 @Builder
 PracownicyDto(Long id,
     UUID uuid,
     LudzieDto czlowiek,
     String stanowisko
    ) {
  this.id = id;
  this.uuid = uuid;
  this.czlowiek = czlowiek;
  this.stanowisko = stanowisko;

 }


}
