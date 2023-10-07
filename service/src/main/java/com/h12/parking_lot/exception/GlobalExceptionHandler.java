package com.h12.parking_lot.exception;


import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Slf4j
@Setter
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        log.error("IllegalArgumentException occurred: URL= {}", request.getRequestURL(), e);
        return e.getLocalizedMessage();
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleItemAlreadyExistsException(HttpServletRequest request, AlreadyExistsException e) {
        log.error("AlreadyExistsException occurred: URL= {}", request.getRequestURL(), e);
        return e.getLocalizedMessage();
    }

    @ExceptionHandler(NotExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleNonExistingItemException(HttpServletRequest request, NotExistsException e) {
        log.error("NotExistsException occurred: URL= {}", request.getRequestURL(), e);
        return e.getLocalizedMessage();
    }
}