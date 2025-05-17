package com.patneh.shelter.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.webjars.NotFoundException;

@Slf4j
public class PracownicyException {

  private static String PRACOWNIK_NOT_FOUND_EXCEPTION = "Pracownik o podanym id nie istnieje. Id: ";

  public static NotFoundException pracownikNotFound(Long id) {
    return new NotFoundException(PRACOWNIK_NOT_FOUND_EXCEPTION + id);
  }
}
