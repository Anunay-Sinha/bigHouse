package com.deeaae.bh.mini.scm.repo;

import com.deeaae.bh.mini.scm.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<OrderEntity, Integer> {

}
