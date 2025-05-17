package com.patneh.shelter.infrasructure.dto.zbiorka;

import java.math.BigDecimal;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateZbiorkaDto {

 private Long id;
 private String nazwa;
 private String cel;
 private BigDecimal kwotaDocelowa;
 private BigDecimal kwotaZebrana;
 private Set<Long> zwierzeta;

 @Builder
 UpdateZbiorkaDto(Long id,
     String nazwa,
     String cel,
     BigDecimal kwotaDocelowa,
     BigDecimal kwotaZebrana,
     Set<Long> zwierzeta) {
  this.id = id;
  this.nazwa = nazwa;
  this.cel = cel;
  this.kwotaDocelowa = kwotaDocelowa;
  this.kwotaZebrana = kwotaZebrana;
  this.zwierzeta = zwierzeta;

 }


}
