package com.inditex.ecommerce.controller;

import com.inditex.ecommerce.dto.request.PriceRequestDto;
import com.inditex.ecommerce.dto.response.PriceResponseDto;
import com.inditex.ecommerce.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

  private final PriceService priceService;

  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }

  @Operation(summary = "Get price by filters")
  @ApiResponses({
      @ApiResponse(
          responseCode = "200",
          description = "Price found with filter parameters",
          content = {@Content(
              mediaType = "application/json",
              schema = @Schema(
                  implementation = PriceResponseDto.class)
          )}
      ),
      @ApiResponse(
          responseCode = "404",
          description = "Price not found",
          content = @Content
      )
  })
  @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Price filter",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(
              implementation = PriceRequestDto.class
          )
      )
  )
  @PostMapping("/filter")
  public ResponseEntity<PriceResponseDto> getPriceByFilter(
      @Valid @RequestBody PriceRequestDto priceRequestDto) {
    return ResponseEntity.ok(this.priceService.getPriceByFilter(priceRequestDto));
  }

}
