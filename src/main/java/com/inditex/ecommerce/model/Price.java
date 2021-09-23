package com.inditex.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Currency;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Price extends EntityBase<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long brandId;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private LocalDateTime startDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private LocalDateTime endDate;

  private Long priceList;

  private Long productId;

  private Long priority;

  private Double sellingPrice;

  private Currency curr;

}
