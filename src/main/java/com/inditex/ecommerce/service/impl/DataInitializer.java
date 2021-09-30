package com.inditex.ecommerce.service.impl;

import com.inditex.ecommerce.model.Price;
import com.inditex.ecommerce.repository.PriceRepository;
import com.inditex.ecommerce.utils.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DataInitializer {

  private final PriceRepository priceRepository;
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.INITIAL_DATA_DATE_FORMAT);

  public DataInitializer(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @PostConstruct
  public void loadDefaultData() {
    List<Price> prices = new ArrayList<>();
    Path pathToFile = Paths.get("src/main/resources/data.csv");

    try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
      String line = br.readLine();

      while (line != null) {
        String[] attributes = line.split(Constants.SEMICOLON);
        Price price = createPrice(attributes);
        prices.add(price);
        line = br.readLine();
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    this.priceRepository.saveAll(prices);
  }

  private Price createPrice(String[] metadata) {

    Long brandId = Long.parseLong(metadata[0]);
    LocalDateTime startDate = LocalDateTime.parse(metadata[1], formatter);
    LocalDateTime endDate = LocalDateTime.parse(metadata[2], formatter);
    Long priceList = Long.parseLong(metadata[3]);
    Long productId = Long.parseLong(metadata[4]);
    Long priority = Long.parseLong(metadata[5]);
    Double sellingPrice = Double.parseDouble(metadata[6]);
    Currency curr = Currency.getInstance(metadata[7]);

    return Price.builder()
        .brandId(brandId)
        .startDate(startDate)
        .endDate(endDate)
        .priceList(priceList)
        .productId(productId)
        .priority(priority)
        .sellingPrice(sellingPrice)
        .curr(curr)
        .build();

  }
}
