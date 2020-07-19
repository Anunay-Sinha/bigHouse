package com.deeaae.bh.al.model;

import java.util.Map;
import lombok.Data;

@Data
public class Pong {


  public Pong() {

  }

  public Pong(String time, String requestParam, String pathParam, Map postBody, Map headers) {
    this.headers = headers;
    this.postBody = postBody;
    this.pathParam = pathParam;
    this.requestParam = requestParam;
    this.serverTime = time;
  }
  String requestParam;
  String pathParam;
  Map postBody;
  Map headers;
  String serverTime;
  String pong = "pong";
}
