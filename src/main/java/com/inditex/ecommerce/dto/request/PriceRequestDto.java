package com.inditex.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceRequestDto {

  @JsonProperty("localDateTime")
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private LocalDateTime localDateTime;

  @JsonProperty("productId")
  private Long productId;

  @JsonProperty("brandId")
  private Long brandId;
}
