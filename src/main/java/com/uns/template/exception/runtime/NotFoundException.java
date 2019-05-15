package com.uns.template.exception.runtime;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.utils.StaticUtils;

/**
 * created by kmluns
 **/
public class NotFoundException extends ApplicationRuntimeException {

    public NotFoundException() {
        super(StaticUtils.getErrorMessageService().getErrorMessageText(ErrorMessageConstant.NOT_FOUND));
    }
}