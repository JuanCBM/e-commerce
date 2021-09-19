package com.inditex.ecommerce.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Price not found")
public class PriceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 6600084908618284957L;
}
