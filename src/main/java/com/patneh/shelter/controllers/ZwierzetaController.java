package com.patneh.shelter.controllers;

import com.patneh.shelter.domain.zwierzeta.ZwierzetaFacade;
import com.patneh.shelter.infrasructure.dto.zwierzeta.CreateZwierzetaDto;
import com.patneh.shelter.infrasructure.dto.zwierzeta.UpdateZwierzetaDto;
import com.patneh.shelter.infrasructure.dto.zwierzeta.ZwierzetaDto;
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
@RequestMapping("/zwierzeta")
public class ZwierzetaController {

 private final ZwierzetaFacade zwierzetaFacade;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return a list of all animals")
  public ResponseEntity<List<ZwierzetaDto>> getAllZwierzeta() {
    return ResponseEntity.ok(zwierzetaFacade.getAllZwierzeta());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return animal by id")
  public ResponseEntity<ZwierzetaDto> getZwierzeDto(@PathVariable Long id) {
    return ResponseEntity.ok(zwierzetaFacade.getZwierzeDto(id));
  }

 @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to create new animal")
 public ResponseEntity<ZwierzetaDto> createZwierze(@RequestBody CreateZwierzetaDto dto) {
  return ResponseEntity.ok(zwierzetaFacade.createZwierze(dto));
 }

 @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to update animal")
 public ResponseEntity<ZwierzetaDto> updateZwierze(@RequestBody UpdateZwierzetaDto dto) {
  return ResponseEntity.ok(zwierzetaFacade.updateZwierze(dto));
 }

 @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to delete animal")
 public ResponseEntity<Void> deleteZwierzeta(@PathVariable Long id) {
  zwierzetaFacade.deleteZwierzeta(id);
  return ResponseEntity.ok().build();
 }

}
