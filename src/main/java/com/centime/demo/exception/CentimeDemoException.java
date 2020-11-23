package com.centime.demo.exception;

import com.centime.exception.CentimeException;

public class CentimeDemoException extends CentimeException {

  // TODO:Rename/Refactor Exception as per service name like - AdminServiceException
  /**
   * Instantiates a new Centime Demo exception.
   * @param errorCode
   *          the error code
   */
  public CentimeDemoException(String errorCode) {
    super(errorCode);
  }
}
