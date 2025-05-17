package com.patneh.shelter.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.webjars.NotFoundException;

@Slf4j
public class ZbiorkaException {

  private static String ZBIORKA_NOT_FOUND_EXCEPTION = "Zbiórka o podanym id nie istnieje. Id: ";

  public static NotFoundException zbiorkaNotFound(Long id) {
    return new NotFoundException(ZBIORKA_NOT_FOUND_EXCEPTION + id);
  }
}
