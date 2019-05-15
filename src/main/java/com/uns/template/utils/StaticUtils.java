package com.uns.template.utils;

import com.uns.template.service.error.ErrorMessageService;

/**
 * created by kmluns 21.01.2019
 **/
public final class StaticUtils {

    private StaticUtils(){}


    private static ErrorMessageService errorMessageService;

    public static ErrorMessageService getErrorMessageService() {
        return errorMessageService;
    }

    public static void setErrorMessageService(ErrorMessageService errorMessageService) {
        StaticUtils.errorMessageService = errorMessageService;
    }
}
