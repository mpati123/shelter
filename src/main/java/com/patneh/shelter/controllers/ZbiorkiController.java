package com.patneh.shelter.controllers;

import com.patneh.shelter.domain.zbiorki.ZbiorkaFacade;
import com.patneh.shelter.infrasructure.dto.zbiorka.CreateZbiorkaDto;
import com.patneh.shelter.infrasructure.dto.zbiorka.UpdateZbiorkaDto;
import com.patneh.shelter.infrasructure.dto.zbiorka.ZbiorkaDto;
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
@RequestMapping("/zbiorki")
public class ZbiorkiController {

 private final ZbiorkaFacade zbiorkaFacade;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return a list of all founding")
  public ResponseEntity<List<ZbiorkaDto>> getAllZbiorki() {
    return ResponseEntity.ok(zbiorkaFacade.getAllZbiorki());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return founding by id")
  public ResponseEntity<ZbiorkaDto> getZbiorkaDto(@PathVariable Long id) {
    return ResponseEntity.ok(zbiorkaFacade.getZbiorkaDto(id));
  }

 @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to create new founding")
 public ResponseEntity<ZbiorkaDto> createZbiorka(@RequestBody CreateZbiorkaDto dto) {
  return ResponseEntity.ok(zbiorkaFacade.createZbiorka(dto));
 }

 @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to update founding")
 public ResponseEntity<ZbiorkaDto> updateZbiorka(@RequestBody UpdateZbiorkaDto dto) {
  return ResponseEntity.ok(zbiorkaFacade.updateZbiorka(dto));
 }

 @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to delete founding")
 public ResponseEntity<Void> deleteZbiorka(@PathVariable Long id) {
  zbiorkaFacade.deleteZbiorka(id);
  return ResponseEntity.ok().build();
 }

}
