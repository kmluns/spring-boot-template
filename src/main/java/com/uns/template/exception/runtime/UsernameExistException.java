package com.uns.template.exception.runtime;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.utils.StaticUtils;

/**
 * created by kmluns
 **/
public class UsernameExistException extends ApplicationRuntimeException {

    public UsernameExistException() {
        super(StaticUtils.getErrorMessageService().getErrorMessageText(ErrorMessageConstant.USERNAME_EXIST));
    }
}
