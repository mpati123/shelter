package com.patneh.shelter.controllers;

import com.patneh.shelter.domain.ludzie.LudzieFacade;
import com.patneh.shelter.infrasructure.dto.ludzie.CreateLudzieDto;
import com.patneh.shelter.infrasructure.dto.ludzie.LudzieDto;
import com.patneh.shelter.infrasructure.dto.ludzie.UpdateLudzieDto;
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
@RequestMapping("/ludzie")
public class LudzieController {

 private final LudzieFacade ludzieFacade;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return a list of all people")
  public ResponseEntity<List<LudzieDto>> getAllLudzie() {
    return ResponseEntity.ok(ludzieFacade.getAllLudzie());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Service to return person by id")
  public ResponseEntity<LudzieDto> getLudzieDto(@PathVariable Long id) {
    return ResponseEntity.ok(ludzieFacade.getLudzieDto(id));
  }

 @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to create new person")
 public ResponseEntity<LudzieDto> createLudzie(@RequestBody CreateLudzieDto dto) {
  return ResponseEntity.ok(ludzieFacade.createLudzie(dto));
 }

 @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to update person")
 public ResponseEntity<LudzieDto> updateLudzie(@RequestBody UpdateLudzieDto dto) {
  return ResponseEntity.ok(ludzieFacade.updateLudzie(dto));
 }

 @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
 @Operation(summary = "Service to delete person")
 public ResponseEntity<Void> deleteLudzie(@PathVariable Long id) {
  ludzieFacade.deleteLudzie(id);
  return ResponseEntity.ok().build();
 }

}
