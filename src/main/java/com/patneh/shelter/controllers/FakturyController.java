package com.patneh.shelter.controllers;

import com.patneh.shelter.domain.faktury.FakturyFacade;
import com.patneh.shelter.infrasructure.dto.faktury.CreateFakturyDto;
import com.patneh.shelter.infrasructure.dto.faktury.FakturyDto;
import com.patneh.shelter.infrasructure.dto.faktury.UpdateFakturyDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/faktury")
public class FakturyController {

 private final FakturyFacade fakturyFacade;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return a list of all invoice")
  public ResponseEntity<List<FakturyDto>> getAllFaktury() {
    return ResponseEntity.ok(fakturyFacade.getAllFaktury());
  }

  @GetMapping(path = "/lecznica/{lecznicaId}",produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return a list of all invoice for hospital")
  public ResponseEntity<List<FakturyDto>> getAllFakturyForLecznica(@PathVariable Long lecznicaId) {
    return ResponseEntity.ok(fakturyFacade.getAllFakturyForLecznica(lecznicaId));
  }

//  @GetMapping(path = "/zwierze/{zwierzeId}",produces = MediaType.APPLICATION_JSON_VALUE)
//  @Operation(summary = "Service to return a list of all invoice for animal")
//  public ResponseEntity<List<FakturyDto>> getAllFakturyForZwierze(@PathVariable Long zwierzeId) {
//    return ResponseEntity.ok(fakturyFacade.getAllFakturyForZwierze(zwierzeId));
//  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return invoice by id")
  public ResponseEntity<FakturyDto> getFaktura(@PathVariable Long id) {
    return ResponseEntity.ok(fakturyFacade.getFakturaDto(id));
  }

 @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to create new invoice")
 public ResponseEntity<FakturyDto> createFaktura(@RequestBody CreateFakturyDto dto) {
  return ResponseEntity.ok(fakturyFacade.createFaktura(dto));
 }

 @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to update invoice")
 public ResponseEntity<FakturyDto> updateFaktura(@RequestBody UpdateFakturyDto dto) {
  return ResponseEntity.ok(fakturyFacade.updateFaktura(dto));
 }

 @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to delete invoice")
 public ResponseEntity<Void> deleteFaktura(@PathVariable Long id) {
  fakturyFacade.deleteFaktura(id);
  return ResponseEntity.ok().build();
 }

}
