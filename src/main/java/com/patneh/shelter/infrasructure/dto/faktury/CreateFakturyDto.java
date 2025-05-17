package com.patneh.shelter.infrasructure.dto.faktury;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateFakturyDto {

 private String numer;
 private LocalDate data;
 private BigDecimal kwota;
 private Long lecznicaId;
 private Set<Long> zwierzeta;

 @Builder
 CreateFakturyDto(String numer,
    LocalDate data,
    BigDecimal kwota,
    Long lecznicaId,
     Set<Long> zwierzeta) {
  this.numer = numer;
  this.data = data;
  this.kwota = kwota;
  this.lecznicaId = lecznicaId;
  this.zwierzeta = zwierzeta;

 }


}
