package com.uns.template.exception.runtime;


import com.uns.template.constant.ErrorMessageConstant;

/**
 * created by kmluns
 **/
public class EmailFormatException extends ApplicationRuntimeException {
    public EmailFormatException(String email){
        super(email + " is not valid",ErrorMessageConstant.PARSE_ERROR);
    }
}
