package com.deeaae.bh.mini.scm.controller;

import com.deeaae.bh.mini.scm.dto.UserDTO;
import com.deeaae.bh.mini.scm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
    userDTO = userService.createUser(userDTO);
    return ResponseEntity.status(201).body(userDTO);
  }

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public ResponseEntity<UserDTO> createUser(@PathVariable String userId) {
    UserDTO userDTO = userService.getUserById(Integer.parseInt(userId));
    return ResponseEntity.ok(userDTO);
  }


}
