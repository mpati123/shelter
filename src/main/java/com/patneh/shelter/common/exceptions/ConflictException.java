package com.patneh.shelter.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends BaseException {

  public ConflictException(String message, Throwable cause) {
    super(message, cause, HttpStatus.CONFLICT);
  }

  public ConflictException(String message) {
    super(message, HttpStatus.CONFLICT);
  }
}
