package no.marius.carappapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CarNotFoundAdvice {

  // @ResponseBody - Signals that this advice is rendered straight into the response body.
  @ResponseBody
  // @ExceptionHandler - configures the advice to only respond if an CarNotFoundException is thrown.
  @ExceptionHandler(CarNotFoundException.class)
  // @ResponseStatus -  says to issue an HttpStatus.NOT_FOUND, i.e. an HTTP 404.
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String carNotFoundHandler(CarNotFoundException ex) {
    return ex.getMessage();
  }
}
