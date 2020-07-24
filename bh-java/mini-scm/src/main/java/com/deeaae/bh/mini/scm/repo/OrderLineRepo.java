package com.deeaae.bh.mini.scm.repo;

import com.deeaae.bh.mini.scm.entity.OrderEntity;
import com.deeaae.bh.mini.scm.entity.OrderLineEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderLineRepo extends CrudRepository<OrderLineEntity, Integer> {
  List<OrderLineEntity> findByOrder(OrderEntity orderEntity);
}
