package com.uns.template.service.error;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.model.localization.ErrorMessage;
import com.uns.template.model.localization.Locale;
import com.uns.template.repository.localization.ErrorMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * created by kmluns
 **/
@Service
public class ErrorMessageService {

    @Autowired
    private ErrorMessageRepository errorMessageRepository;

    public ErrorMessage getErrorMessage(int errorCode) {
        ErrorMessage errorMessage =  errorMessageRepository.findByErrorCodeAndLocale(errorCode, Locale.valueOf(LocaleContextHolder.getLocale().getLanguage()));
        if(errorMessage == null){
            return errorMessageRepository.findByErrorCodeAndLocale(ErrorMessageConstant.UNKNOWN_ERROR, Locale.valueOf(LocaleContextHolder.getLocale().getLanguage()));
        }
        return errorMessage;
    }

    public String getErrorMessageText(int errorCode) {
        ErrorMessage errorMessage = errorMessageRepository.findByErrorCodeAndLocale(errorCode, Locale.valueOf(LocaleContextHolder.getLocale().getLanguage()));
        if(errorMessage == null){
            return errorMessageRepository.findByErrorCodeAndLocale(ErrorMessageConstant.UNKNOWN_ERROR, Locale.valueOf(LocaleContextHolder.getLocale().getLanguage())).getMessage();
        }
        return errorMessage.getMessage();
    }
}
