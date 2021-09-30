package com.inditex.ecommerce.exception;

import java.io.Serial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Price not found")
public class PriceNotFoundException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 6600084908618284957L;
}
