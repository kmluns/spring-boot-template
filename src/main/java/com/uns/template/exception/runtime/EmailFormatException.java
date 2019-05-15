package com.uns.template.exception.runtime;

/**
 * created by kmluns
 **/
public class EmailFormatException extends ApplicationRuntimeException {
    public EmailFormatException(String email){
        super(email + " is not valid");
    }
}
