package com.uns.template.exception;

/**
 * created by kmluns
 **/
public class EmailFormatException extends RuntimeException{
    public EmailFormatException(String email){
        super(email + " is not valid");
    }
}
