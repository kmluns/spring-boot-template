package com.uns.template.exception;

import com.uns.template.service.error.ErrorMessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by kmluns
 **/
public class AuthenticationException extends RuntimeException {

    @Autowired
    ErrorMessageService errorMessageService;

}
