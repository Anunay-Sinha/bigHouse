package com.deeaae.bh.mini.scm.service;

import com.deeaae.bh.mini.scm.dto.UserDTO;
import com.deeaae.bh.mini.scm.entity.UserEntity;
import com.deeaae.bh.mini.scm.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
  @Autowired
  private UserRepo userRepo;

  public UserDTO createUser(UserDTO userDTO) {
    log.info("creating a new user ", userDTO);
    UserDTO existingUserDTO = getUserByIdWithoutExceptions(userDTO.getId());
    if(existingUserDTO == null) {
      UserEntity userEntity = Mapper.getEntityFromDto(userDTO);
      userEntity = userRepo.save(userEntity);
      log.info("user created ", userEntity);
      return Mapper.getDtoFromEntity(userEntity);
    } else {
      throw new RuntimeException("User already exist with id "+  userDTO.getId());
    }
  }

  private UserDTO getUserByIdWithoutExceptions(Integer id) {
    try {
      return getUserById(id);
    } catch (Exception ex) {
      log.warn("error fetching user details", ex);
      return null;
    }
  }

  public UserDTO getUserById(Integer id) {
    UserEntity userEntity;
    userEntity = userRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("User with id "+ id + " not found"));
    return Mapper.getDtoFromEntity(userEntity);
  }


}

class Mapper {
  public  static UserEntity getEntityFromDto(UserDTO userDTO) {
    UserEntity userEntity = new UserEntity();
    userEntity.setEmailId(userDTO.getEmailId());
    userEntity.setId(userDTO.getId());
    userEntity.setName(userDTO.getName());
    return userEntity;
  }

  public static UserDTO getDtoFromEntity(UserEntity userEntity) {
    UserDTO userDTO = new UserDTO();
    userDTO.setEmailId(userEntity.getEmailId());
    userDTO.setId(userEntity.getId());
    userDTO.setName(userEntity.getName());
    return userDTO;
  }

}
