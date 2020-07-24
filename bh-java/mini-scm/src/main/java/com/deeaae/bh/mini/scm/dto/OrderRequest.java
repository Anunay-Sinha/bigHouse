package com.deeaae.bh.mini.scm.dto;

import java.util.Map;
import lombok.Data;

@Data
public class OrderRequest {
  private Integer userId;
  private Map<Integer, Integer> productQuantityMap;
  private Integer totalCost;
}
