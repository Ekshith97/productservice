package com.scaler.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArithmeticExceptionDto {

    private String message;
    private String details;


    public ArithmeticExceptionDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ArithmeticExceptionDto{" +
                "message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }


}
