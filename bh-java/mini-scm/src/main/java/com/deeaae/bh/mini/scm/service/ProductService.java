package com.deeaae.bh.mini.scm.service;

import com.deeaae.bh.mini.scm.dto.ProductDTO;
import com.deeaae.bh.mini.scm.dto.UserDTO;
import com.deeaae.bh.mini.scm.entity.ProductEntity;
import com.deeaae.bh.mini.scm.entity.UserEntity;
import com.deeaae.bh.mini.scm.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {
  @Autowired
  private ProductRepo productRepo;

  public ProductDTO addProduct(ProductDTO productDTO) {
    log.info("creating a new product ", productDTO);
    ProductDTO existingProductDTO = getProductByIdWithoutExceptions(productDTO.getId());
    if(existingProductDTO == null) {
      ProductEntity productEntity = ProductMapper.getEntityFromDto(productDTO);
      productEntity = productRepo.save(productEntity);
      log.info("product created ", productEntity);
      return ProductMapper.getDtoFromEntity(productEntity);
    } else {
      throw new RuntimeException("Product already exist with id "+  productDTO.getId());
    }
  }

  private ProductDTO getProductByIdWithoutExceptions(Integer id) {
    try {
      return getProductById(id);
    } catch (Exception ex) {
      log.warn("error fetching product details details", ex);
      return null;
    }
  }

  public ProductDTO getProductById(Integer id) {
    ProductEntity productEntity;
    productEntity = productRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Product with id "+ id + " not found"));
    return ProductMapper.getDtoFromEntity(productEntity);
  }


}

class ProductMapper {
  public  static ProductEntity getEntityFromDto(ProductDTO productDTO) {
    ProductEntity productEntity = new ProductEntity();
    productEntity.setId(productDTO.getId());
    productEntity.setMrp(productDTO.getMrp());
    productEntity.setName(productDTO.getName());
    return productEntity;
  }

  public static ProductDTO getDtoFromEntity(ProductEntity productEntity) {
    ProductDTO productDTO  = new ProductDTO();
    productDTO.setId(productEntity.getId());
    productDTO.setMrp(productEntity.getMrp());
    productDTO.setName(productEntity.getName());
    return productDTO;

  }

}
