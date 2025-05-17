package com.patneh.shelter.controllers;

import com.patneh.shelter.domain.lecznice.LecznicaFacade;
import com.patneh.shelter.infrasructure.dto.lecznica.CreateLecznicaDto;
import com.patneh.shelter.infrasructure.dto.lecznica.LecznicaDto;
import com.patneh.shelter.infrasructure.dto.lecznica.UpdateLecznicaDto;
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
@RequestMapping("/lecznica")
public class LecznicaController {

 private final LecznicaFacade lecznicaFacade;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return a list of all hospitals")
  public ResponseEntity<List<LecznicaDto>> getAllLecznice() {
    return ResponseEntity.ok(lecznicaFacade.getAllLecznice());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return hospital by id")
  public ResponseEntity<LecznicaDto> getLecznicaDto(@PathVariable Long id) {
    return ResponseEntity.ok(lecznicaFacade.getLecznicaDto(id));
  }

 @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to create new hospital")
 public ResponseEntity<LecznicaDto> createLecznica(@RequestBody CreateLecznicaDto dto) {
  return ResponseEntity.ok(lecznicaFacade.createLecznica(dto));
 }

 @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to update hospital")
 public ResponseEntity<LecznicaDto> updateLecznica(@RequestBody UpdateLecznicaDto dto) {
  return ResponseEntity.ok(lecznicaFacade.updateLecznica(dto));
 }

 @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to delete hospital")
 public ResponseEntity<Void> deleteLecznica(@PathVariable Long id) {
  lecznicaFacade.deleteLecznica(id);
  return ResponseEntity.ok().build();
 }

}
