package com.deeaae.bh.al.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan({"com.deeaae.bh.*","org.commonsources.correlation.*"})
public class ALApplication {
  public static void main(String[] args) {
    SpringApplication.run(ALApplication.class, args);
  }

}
