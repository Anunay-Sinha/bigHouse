package com.deeaae.bh.mini.scm.repo;

import com.deeaae.bh.mini.scm.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Integer> {

}
