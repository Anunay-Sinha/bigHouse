package com.deeaae.bh.mini.scm.controller;

import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

  @RequestMapping(value = "/ping", method = RequestMethod.GET)
  public ResponseEntity<String> ping() {
    return ResponseEntity.ok("Pong @ " + LocalDateTime.now().toString());
  }

}
