package com.deeaae.bh.xp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.deeaae.bh.xp")
public class XpApplication {
  public static void main(String[] args) {
    SpringApplication.run(XpApplication.class, args);
  }
}
