package com.centime.oidc.exception;

import com.centime.exception.CentimeException;

public class CentimeOIDCException extends CentimeException {

  // TODO:Rename/Refactor Exception as per service name like - AdminServiceException
  /**
   * Instantiates a new Centime Demo exception.
   * @param errorCode
   *          the error code
   */
  public CentimeOIDCException(String errorCode) {
    super(errorCode);
  }
}
