package com.scaler.productservice.controllerAdvices;

import com.scaler.productservice.dtos.ArithmeticExceptionDto;
import com.scaler.productservice.dtos.exceptiondto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handlerAtithmaticException(Exception e)
    {
       //eturn new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        // we can also create DTO and send info in a clear way
        ArithmeticExceptionDto adto=new ArithmeticExceptionDto();
        adto.setMessage("AritmeticException");
        adto.setDetails("something went wrong");
        return new ResponseEntity<>(adto,HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<exceptiondto>  ProductNotFoundExceptionHandler(ProductNotFoundException e)
    {
        exceptiondto exceptionDto = new exceptiondto();
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setDetails("Product not found");
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
