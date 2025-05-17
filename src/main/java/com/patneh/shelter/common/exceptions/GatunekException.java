package com.patneh.shelter.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.webjars.NotFoundException;

@Slf4j
public class GatunekException {

  private static String GATUNEK_NOT_FOUND_EXCEPTION = "Gatunek o podanym id nie istnieje. Id: ";

  public static NotFoundException gatunekNotFound(Long id) {
    return new NotFoundException(GATUNEK_NOT_FOUND_EXCEPTION + id);
  }
}
