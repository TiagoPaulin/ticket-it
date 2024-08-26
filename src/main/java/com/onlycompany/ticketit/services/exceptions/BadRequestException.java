package com.onlycompany.ticketit.services.exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException (String msg) {
        super(msg);

    }

}
