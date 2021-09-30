package com.inditex.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

public interface PriceResponseDto {

  @Schema(description = "Product id", type = "number", example = "35455")
  Long getProductId();

  @Schema(description = "Brand id", type = "number", example = "1")
  Long getBrandId();

  @Schema(description = "Price list", type = "number", example = "1")
  Long getPriceList();

  @Schema(description = "Start date", type = "string", format = "date-time", example = "2020-06-14T00:00:00Z")
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  LocalDateTime getStartDate();

  @Schema(description = "End date", type = "string", format = "date-time", example = "2020-12-31T23:59:59Z")
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  LocalDateTime getEndDate();

  @Schema(description = "Selling price", type = "number", example = "35.5")
  Double getSellingPrice();
}
