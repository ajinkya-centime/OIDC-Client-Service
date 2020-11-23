package com.centime.demo.controller;

import com.centime.controller.BaseController;
import com.centime.demo.constants.EndpointConstants;
import com.centime.demo.constants.TemplateServiceExceptionCode;
import com.centime.demo.exception.CentimeDemoException;
import com.centime.logging.CentimeLogger;
import com.centime.model.common.Response;

import com.centime.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.BASE_V1_API)
public class Demo extends BaseController {
  // TODO:Rename/Refactor Controller name and path e.g OnboardingSevice

  private static final CentimeLogger log = CentimeLogger.getLogger();

  @PostMapping(EndpointConstants.HELLO_WORLD)
  public ResponseEntity<Response<String>> returnRequestString(@RequestBody String sampleInput,
      @RequestHeader(value = CLIENT_ID) Integer clientId,
      @RequestHeader(value = LOGIN_ID) String loginId)
      throws CentimeDemoException {

    Response<String> response = new Response<>();

    if (!("helloworld".equalsIgnoreCase(sampleInput))) {
      log.error("Input string : {} does not match helloworld",sampleInput);
      throw new CentimeDemoException(TemplateServiceExceptionCode.STRING_MISMATCH.getCode());
    }

    // use ResponseUtil from the common lib to generate success response with data
    response = ResponseUtil.generateSuccessResponse(sampleInput);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
