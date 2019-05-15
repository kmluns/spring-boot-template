package com.uns.template.exception.runtime;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.utils.StaticUtils;

/**
 * created by kmluns 21.01.2019
 **/
public class ParseException extends ApplicationRuntimeException {
    public ParseException() {
        super(StaticUtils.getErrorMessageService().getErrorMessageText(ErrorMessageConstant.PARSE_ERROR));
    }
}
