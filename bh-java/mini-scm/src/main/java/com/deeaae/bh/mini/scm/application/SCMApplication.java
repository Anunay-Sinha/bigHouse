package com.deeaae.bh.mini.scm.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
    When the repository package is different to @SpringBootApplication/@EnableAutoConfiguration,
    base package of @EnableJpaRepositories is required to be defined explicitly.
    https://stackoverflow.com/questions/29221645/cant-autowire-repository-annotated-interface-in-spring-boot
 */

@SpringBootApplication()
@ComponentScan({"com.deeaae.bh.*","org.commonsources.correlation.*"})
@EnableJpaRepositories("com.deeaae.bh.*")
@EntityScan("com.deeaae.bh.*")
public class SCMApplication {
  public static void main(String[] args) {
    SpringApplication.run(SCMApplication.class, args);
  }
}
