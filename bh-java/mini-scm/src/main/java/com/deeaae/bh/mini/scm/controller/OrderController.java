package com.deeaae.bh.mini.scm.controller;

import com.deeaae.bh.mini.scm.dto.OrderRequest;
import com.deeaae.bh.mini.scm.entity.OrderEntity;
import com.deeaae.bh.mini.scm.entity.OrderLineEntity;
import com.deeaae.bh.mini.scm.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<Integer> createOrder(@RequestBody OrderRequest orderRequest) {
    return ResponseEntity.ok(orderService.createOrder(orderRequest));
  }

  @RequestMapping(value = "/{orderId}/orderLine", method = RequestMethod.GET)
  public ResponseEntity<List<OrderLineEntity>> getOrderLine(@PathVariable Integer orderId) {
    return ResponseEntity.ok(orderService.findOrderLinesByOrderId(orderId));
  }

  @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
  public ResponseEntity<OrderEntity> getOrder(@PathVariable Integer orderId) {
    return ResponseEntity.ok(orderService.findOrderById(orderId));
  }


}
