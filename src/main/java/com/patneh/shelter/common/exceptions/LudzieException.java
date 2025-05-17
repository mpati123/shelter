package com.patneh.shelter.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.webjars.NotFoundException;

@Slf4j
public class LudzieException {

  private static String LUDZIE_NOT_FOUND_EXCEPTION = "Człowiek o podanym id nie istnieje. Id: ";

  public static NotFoundException ludzieNotFound(Long id) {
    return new NotFoundException(LUDZIE_NOT_FOUND_EXCEPTION + id);
  }
}
