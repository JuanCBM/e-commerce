package com.inditex.ecommerce.model;

import java.time.LocalDateTime;
import java.util.Currency;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Price {

  @Id
  private Long id;

  private Long brandId;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Long priceList;

  private Long productId;

  private Long priority;

  private Double price;

  private Currency curr;

}
