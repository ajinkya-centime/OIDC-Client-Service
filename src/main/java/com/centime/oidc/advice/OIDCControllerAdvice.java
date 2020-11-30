package com.centime.oidc.advice;

import com.centime.enums.StatusEnum;
import com.centime.error.ErrorCodes;
import com.centime.exception.NoSuchErrorException;
import com.centime.model.common.Response;
import com.centime.oidc.controller.OIDCController;
import com.centime.oidc.exception.CentimeOIDCException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller advice for Signup Controller
 */
@ControllerAdvice(assignableTypes = { OIDCController.class })
public class OIDCControllerAdvice {
  // TODO:Rename/Refactor Controller Advice and change assignable Types above as per list of
  // controller classes

  /**
   * The Error codes.
   */
  @Autowired
  ErrorCodes errorCodes;

  /**
   * Demo exception response entity.
   * @param e
   *          the e
   * @return the response entity
   * @throws CentimeOIDCException
   *           the no such error exception
   */
  @ExceptionHandler(CentimeOIDCException.class)
  public ResponseEntity<Response> centimeDemoException(final CentimeOIDCException e)
      throws NoSuchErrorException {
    Response responseObject = new Response();
    responseObject.addError(errorCodes.getError(e.getErrorCode()));
    responseObject.setStatus(StatusEnum.FAILURE);
    return new ResponseEntity<>(responseObject, HttpStatus.OK);
  }

}
