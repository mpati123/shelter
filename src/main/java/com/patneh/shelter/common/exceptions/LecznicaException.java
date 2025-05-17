package com.patneh.shelter.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.webjars.NotFoundException;

@Slf4j
public class LecznicaException {

  private static String LECZNICA_NOT_FOUND_EXCEPTION = "Lecznica o podanym id nie istnieje. Id: ";

  public static NotFoundException lecznicaNotFound(Long id) {
    return new NotFoundException(LECZNICA_NOT_FOUND_EXCEPTION + id);
  }
}
