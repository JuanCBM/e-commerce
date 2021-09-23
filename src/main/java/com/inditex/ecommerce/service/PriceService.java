package com.inditex.ecommerce.service;

import com.inditex.ecommerce.dto.request.PriceRequestDto;
import com.inditex.ecommerce.dto.response.PriceResponseDto;

public interface PriceService {

  PriceResponseDto getPriceByFilter(PriceRequestDto priceRequestDto);

}
