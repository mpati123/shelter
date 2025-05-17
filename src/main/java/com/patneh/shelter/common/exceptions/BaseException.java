package com.patneh.shelter.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

  @Getter
  protected HttpStatus httpStatus;

  @Getter
  protected String errorResult;

  @Getter
  protected String errorReason;

  @Getter
  protected String errorSolution;

  @Getter
  protected String errorHelp;

  public BaseException(
      String message,
      Throwable cause,
      String errorSolution,
      HttpStatus httpStatus,
      String errorHelp) {
    this(message, cause, errorSolution, httpStatus);
    this.errorHelp = errorHelp;
  }

  public BaseException(
      String message, Throwable cause, String errorSolution, HttpStatus httpStatus) {
    super(message, cause);
    this.httpStatus = httpStatus;
    this.errorResult = message;
    this.errorReason = cause.getLocalizedMessage();
    this.errorSolution = errorSolution;
  }

  public BaseException(String message, Throwable cause, HttpStatus httpStatus) {
    super(message, cause);
    this.httpStatus = httpStatus;
    this.errorResult = message;
    this.errorReason = cause.getLocalizedMessage();
    this.errorSolution = "";
    this.errorHelp = "";
  }

  public BaseException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
    this.errorResult = message;
    this.errorReason = "";
    this.errorSolution = "";
    this.errorHelp = "";
  }
}
