package com.uns.template.exception.runtime;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.utils.StaticUtils;

/**
 * created by kmluns
 **/
public class AuthenticationException extends ApplicationRuntimeException {

    public AuthenticationException() {
        super(StaticUtils.getErrorMessageService().getErrorMessageText(ErrorMessageConstant.AUTHENTICATION_ERROR));
    }

}
