package com.deeaae.bh.mini.scm.service;

import com.deeaae.bh.mini.scm.dto.OrderRequest;
import com.deeaae.bh.mini.scm.dto.ProductDTO;
import com.deeaae.bh.mini.scm.entity.OrderEntity;
import com.deeaae.bh.mini.scm.entity.OrderLineEntity;
import com.deeaae.bh.mini.scm.repo.OrderLineRepo;
import com.deeaae.bh.mini.scm.repo.OrderRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private UserService userService;

  @Autowired
  private ProductService productService;

  @Autowired
  private OrderRepo orderRepo;

  @Autowired
  private OrderLineRepo orderLineRepo;

  public OrderEntity findOrderById(Integer orderId) {
    return orderRepo.findById(orderId).get();
  }

  public List<OrderLineEntity> findOrderLinesByOrderId(Integer orderId) {
    OrderEntity orderEntity = orderRepo.findById(orderId).get();
    List<OrderLineEntity> orderLineEntities =  orderLineRepo.findByOrder(orderEntity);
    return orderLineEntities;
  }

  public Integer createOrder(OrderRequest orderRequest) {
    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setUserEntity(Mapper.getEntityFromDto(userService.getUserById(orderRequest.getUserId())));
    orderEntity.setTotalCost(orderRequest.getTotalCost());
    orderRepo.save(orderEntity);
    Set<OrderLineEntity> orderLineEntitySet = new HashSet<>();
    orderRequest.getProductQuantityMap().forEach((x,y) -> {
      OrderLineEntity orderLineEntity = new OrderLineEntity();
      ProductDTO productDTO = productService.getProductById(x);
      orderLineEntity.setCost(productDTO.getMrp());
      //orderLineEntity.setProductEntity(ProductMapper.getEntityFromDto(productDTO));
      orderLineEntity.setQuantity(y);
      //orderLineEntity.setOrder(orderEntity);
      orderLineEntitySet.add(orderLineEntity);
      orderLineRepo.save(orderLineEntity);
    });
    orderEntity.setOrderLines(orderLineEntitySet);

    return orderEntity.getId();
  }

}
