package com.deeaae.bh.mini.scm.controller;

import com.deeaae.bh.mini.scm.dto.ProductDTO;
import com.deeaae.bh.mini.scm.dto.UserDTO;
import com.deeaae.bh.mini.scm.entity.ProductEntity;
import com.deeaae.bh.mini.scm.service.ProductService;
import com.deeaae.bh.mini.scm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<ProductDTO> createUser(@RequestBody ProductDTO productDTO) {
    productDTO = productService.addProduct(productDTO);
    return ResponseEntity.status(201).body(productDTO);
  }

  @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
  public ResponseEntity<ProductDTO> createUser(@PathVariable String productId) {
    ProductDTO productDTO = productService.getProductById(Integer.parseInt(productId));
    return ResponseEntity.ok(productDTO);
  }

}
