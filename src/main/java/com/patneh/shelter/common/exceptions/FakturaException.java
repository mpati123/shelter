package com.patneh.shelter.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.webjars.NotFoundException;

@Slf4j
public class FakturaException {

  private static String FAKTURA_NOT_FOUND_EXCEPTION = "Faktura o podanym id nie istnieje. Id: ";

  public static NotFoundException fakturaNotFound(Long id) {
    return new NotFoundException(FAKTURA_NOT_FOUND_EXCEPTION + id);
  }
}
