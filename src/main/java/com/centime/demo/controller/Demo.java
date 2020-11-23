package com.centime.demo.controller;

import com.centime.controller.BaseController;
import com.centime.logging.CentimeLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-service/1.0")
public class Demo  extends BaseController {
    private static final CentimeLogger log = CentimeLogger.getLogger();


    @PostMapping("/helloworld")
    public ResponseEntity<String> returnRequestString(@RequestBody String sampleInput) {

        return new ResponseEntity<String>(sampleInput,HttpStatus.OK);
    }

}
