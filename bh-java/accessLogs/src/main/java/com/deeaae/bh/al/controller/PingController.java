package com.deeaae.bh.al.controller;

import com.deeaae.bh.al.model.Pong;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<Pong> ping(@RequestParam(required = false, defaultValue = "001") String id, @RequestHeader Map<String, String> headers) {
    Pong pong = new Pong(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), id, null, null, headers);
    return ResponseEntity.ok(pong);
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<Pong> postPing( @RequestBody Map<String, String> data, @RequestHeader Map<String, String> headers) {
    Pong pong = new Pong(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), null, null, data, headers);
    return ResponseEntity.ok(pong);

  }


}