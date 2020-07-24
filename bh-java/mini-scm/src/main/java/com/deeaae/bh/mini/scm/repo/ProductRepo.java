package com.deeaae.bh.mini.scm.repo;

import com.deeaae.bh.mini.scm.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductEntity, Integer> {

}
