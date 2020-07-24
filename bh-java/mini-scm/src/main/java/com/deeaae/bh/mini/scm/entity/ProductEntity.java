package com.deeaae.bh.mini.scm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProductEntity {
  @Id
  private Integer id;
  private String name;
  private Integer mrp;
}
