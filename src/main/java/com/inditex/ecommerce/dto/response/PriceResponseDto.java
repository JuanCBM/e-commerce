package com.inditex.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public interface PriceResponseDto {

  Long getProductId();

  Long getBrandId();

  Long getPriceList();

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  LocalDateTime getStartDate();

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  LocalDateTime getEndDate();

  Double getSellingPrice();
}
