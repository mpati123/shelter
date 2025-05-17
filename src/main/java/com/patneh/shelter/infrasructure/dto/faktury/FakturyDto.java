package com.patneh.shelter.infrasructure.dto.faktury;

import com.patneh.shelter.infrasructure.dto.lecznica.LecznicaDto;
import com.patneh.shelter.infrasructure.dto.zwierzeta.ZwierzetaDto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FakturyDto {

 private Long id;
 private UUID uuid;
 private String numer;
 private LocalDate data;
 private BigDecimal kwota;
 private LecznicaDto lecznica;
 private Set<ZwierzetaDto> zwierzeta;

 @Builder FakturyDto(Long id,
    UUID uuid,
    String numer,
    LocalDate data,
    BigDecimal kwota,
    LecznicaDto lecznica,
    Set<ZwierzetaDto> zwierzeta) {
  this.id = id;
  this.uuid = uuid;
  this.numer = numer;
  this.data = data;
  this.kwota = kwota;
  this.lecznica = lecznica;
  this.zwierzeta = zwierzeta;

 }


}
