package com.inditex.ecommerce.e2e;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.ecommerce.dto.request.PriceRequestDto;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("e2e PriceControllerTest")
class PriceControllerTest {

  private final long BRAND_ID = 1;
  private final long PRODUCT_ID = 35455;

  @Autowired
  private MockMvc mockMvc;
  private final ObjectMapper objectMapper;

  PriceControllerTest() {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.findAndRegisterModules();
  }

  @Test
  @DisplayName("Get price test 1")
  void getPriceTest1() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-14T10:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo(1)))
        .andExpect(jsonPath("$.productId", equalTo(35455)))
        .andExpect(jsonPath("$.priceList", equalTo(1)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(35.5)));
  }

  @Test
  @DisplayName("Get price test 2")
  void getPriceTest2() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-14T16:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo(1)))
        .andExpect(jsonPath("$.productId", equalTo(35455)))
        .andExpect(jsonPath("$.priceList", equalTo(2)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(25.45)));
  }

  @Test
  @DisplayName("Get price test 3")
  void getPriceTest3() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-14T21:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo(1)))
        .andExpect(jsonPath("$.productId", equalTo(35455)))
        .andExpect(jsonPath("$.priceList", equalTo(1)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(35.5)));
  }

  @Test
  @DisplayName("Get price test 4")
  void getPriceTest4() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-15T10:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo(1)))
        .andExpect(jsonPath("$.productId", equalTo(35455)))
        .andExpect(jsonPath("$.priceList", equalTo(3)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(30.5)));
  }

  @Test
  @DisplayName("Get price test 5")
  void getPriceTest5() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-16T21:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo(1)))
        .andExpect(jsonPath("$.productId", equalTo(35455)))
        .andExpect(jsonPath("$.priceList", equalTo(4)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(38.95)));

  }

  private ResultActions runTestGetPrice(PriceRequestDto priceRequestDto) throws Exception {
    return this.mockMvc.perform(post("/api/prices/filter")
        .content(objectMapper.writeValueAsString(priceRequestDto))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
  }

}
