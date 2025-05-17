package com.patneh.shelter.controllers;

import com.patneh.shelter.domain.gatunki.GatunekFacade;
import com.patneh.shelter.infrasructure.dto.gatunek.CreateGatunekDto;
import com.patneh.shelter.infrasructure.dto.gatunek.GatunekDto;
import com.patneh.shelter.infrasructure.dto.gatunek.UpdateGatunekDto;
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
@RequestMapping("/gatunki")
public class GatunekController {

 private final GatunekFacade gatunekFacade;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return a list of all species")
  public ResponseEntity<List<GatunekDto>> getAllGatunki() {
    return ResponseEntity.ok(gatunekFacade.getAllGatunki());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return species by id")
  public ResponseEntity<GatunekDto> getGatunekDto(@PathVariable Long id) {
    return ResponseEntity.ok(gatunekFacade.getGatunekDto(id));
  }

 @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to create new species")
 public ResponseEntity<GatunekDto> createGatunek(@RequestBody CreateGatunekDto dto) {
  return ResponseEntity.ok(gatunekFacade.createGatunek(dto));
 }

 @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to update species")
 public ResponseEntity<GatunekDto> updateGatunek(@RequestBody UpdateGatunekDto dto) {
  return ResponseEntity.ok(gatunekFacade.updateGatunek(dto));
 }

 @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to delete species")
 public ResponseEntity<Void> deleteGatunek(@PathVariable Long id) {
  gatunekFacade.deleteGatunek(id);
  return ResponseEntity.ok().build();
 }

}
