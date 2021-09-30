package com.inditex.ecommerce.repository;

import com.inditex.ecommerce.dto.request.PriceRequestDto;
import com.inditex.ecommerce.dto.response.PriceResponseDto;
import com.inditex.ecommerce.model.Price;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

  @Query(value =
      "SELECT p.product_id as productId, p.brand_id as brandId, p.price_list as priceList, "
          + " p.start_date as startDate, p.end_date as endDate, p.selling_price as sellingPrice "
          + " FROM price p "
          + " WHERE p.product_id= :#{#priceRequestDto.productId} AND "
          + "      p.brand_id= :#{#priceRequestDto.brandId} AND "
          + "      :#{#priceRequestDto.localDateTime} BETWEEN p.start_date AND p.end_date "
          + " ORDER BY p.priority DESC, p.creation_timestamp DESC, p.id DESC "
          + " LIMIT 1", nativeQuery = true)
  Optional<PriceResponseDto> getPriceByFilter(
      @Param("priceRequestDto") PriceRequestDto priceRequestDto);
}
