package com.deeaae.bh.al.application.ALApplication;

@SpringBootApplication()
@ComponentScan("com.deeaae.bh.xp")
public class ALApplication {
  public static void main(String[] args) {
    SpringApplication.run(XpApplication.class, args);
  }

}
