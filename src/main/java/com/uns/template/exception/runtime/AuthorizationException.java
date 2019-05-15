package com.uns.template.exception.runtime;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.utils.StaticUtils;

/**
 * created by kmluns
 **/
public class AuthorizationException extends ApplicationRuntimeException {

    public AuthorizationException() {
        super(StaticUtils.getErrorMessageService().getErrorMessageText(ErrorMessageConstant.AUTHORIZATION_ERROR));
    }
}
