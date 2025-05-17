package com.patneh.shelter.controllers;

import com.patneh.shelter.domain.pracownicy.PracownicyFacade;
import com.patneh.shelter.infrasructure.dto.pracownicy.CreatePracownicyDto;
import com.patneh.shelter.infrasructure.dto.pracownicy.PracownicyDto;
import com.patneh.shelter.infrasructure.dto.pracownicy.UpdatePracownicyDto;
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
@RequestMapping("/pracownicy")
public class PracownicyController {

 private final PracownicyFacade pracownicyFacade;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return a list of all employers")
  public ResponseEntity<List<PracownicyDto>> getAllPracownicy() {
    return ResponseEntity.ok(pracownicyFacade.getAllPracownicy());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return employer by id")
  public ResponseEntity<PracownicyDto> getPracownikDto(@PathVariable Long id) {
    return ResponseEntity.ok(pracownicyFacade.getPracownikDto(id));
  }

 @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to create new employer")
 public ResponseEntity<PracownicyDto> createPracownik(@RequestBody CreatePracownicyDto dto) {
  return ResponseEntity.ok(pracownicyFacade.createPracownik(dto));
 }

 @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to update employer")
 public ResponseEntity<PracownicyDto> updatePracownik(@RequestBody UpdatePracownicyDto dto) {
  return ResponseEntity.ok(pracownicyFacade.updatePracownik(dto));
 }

 @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to delete employer")
 public ResponseEntity<Void> deletePracownik(@PathVariable Long id) {
  pracownicyFacade.deletePracownik(id);
  return ResponseEntity.ok().build();
 }

}
