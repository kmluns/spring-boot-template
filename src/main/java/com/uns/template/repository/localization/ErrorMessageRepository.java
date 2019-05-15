package com.uns.template.repository.localization;

import com.uns.template.model.localization.ErrorMessage;
import com.uns.template.model.localization.Locale;
import org.springframework.data.repository.CrudRepository;

/**
 * created by kmluns
 **/
public interface ErrorMessageRepository extends CrudRepository<ErrorMessage,String> {

    ErrorMessage findByErrorCodeAndLocale(int errorCode, Locale locale);


}
