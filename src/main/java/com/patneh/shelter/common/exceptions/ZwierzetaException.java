package com.patneh.shelter.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.webjars.NotFoundException;

@Slf4j
public class ZwierzetaException {

  private static String ZWIERZE_NOT_FOUND_EXCEPTION = "Zwierzę o podanym id nie istnieje. Id: ";

  public static NotFoundException zwierzeNotFound(Long id) {
    return new NotFoundException(ZWIERZE_NOT_FOUND_EXCEPTION + id);
  }
}
