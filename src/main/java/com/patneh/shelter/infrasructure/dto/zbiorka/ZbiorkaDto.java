package com.patneh.shelter.infrasructure.dto.zbiorka;

import com.patneh.shelter.infrasructure.dto.zwierzeta.ZwierzetaDto;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ZbiorkaDto {

 private Long id;
 private UUID uuid;
 private String nazwa;
 private String cel;
 private BigDecimal kwotaDocelowa;
 private BigDecimal kwotaZebrana;
 private Set<ZwierzetaDto> zwierzeta;

 @Builder
 ZbiorkaDto(Long id,
     UUID uuid,
     String nazwa,
     String cel,
     BigDecimal kwotaDocelowa,
     BigDecimal kwotaZebrana,
     Set<ZwierzetaDto> zwierzeta) {
  this.id = id;
  this.uuid = uuid;
  this.nazwa = nazwa;
  this.cel = cel;
  this.kwotaDocelowa = kwotaDocelowa;
  this.kwotaZebrana = kwotaZebrana;
  this.zwierzeta = zwierzeta;

 }


}
