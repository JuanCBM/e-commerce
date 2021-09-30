package com.inditex.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inditex.ecommerce.utils.Constants;
import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceRequestDto {

  @NotNull(message = "localDateTime is mandatory")
  @JsonProperty("localDateTime")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.STANDARD_DATE_FORMAT)
  private LocalDateTime localDateTime;

  @Min(1)
  @NotNull(message = "productId is mandatory")
  @JsonProperty("productId")

  private Long productId;

  @Min(1)
  @NotNull(message = "brandId is mandatory")
  @JsonProperty("brandId")
  private Long brandId;
}
