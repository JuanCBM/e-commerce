package com.inditex.ecommerce.service.impl;

import com.inditex.ecommerce.dto.request.PriceRequestDto;
import com.inditex.ecommerce.dto.response.PriceResponseDto;
import com.inditex.ecommerce.repository.PriceRepository;
import com.inditex.ecommerce.service.PriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

  private PriceRepository priceRepository;

  public PriceServiceImpl(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @Override
  public PriceResponseDto getPriceByFilter(PriceRequestDto priceRequestDto) {
    return priceRepository.getPriceByFilter(priceRequestDto);
  }

}
