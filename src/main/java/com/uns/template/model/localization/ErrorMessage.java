package com.uns.template.model.localization;

import com.uns.template.model.utils.Base;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * created by kmluns
 **/
@Document
@Accessors(chain = true)
public class ErrorMessage extends Base {

    @Getter
    @Setter
    @Indexed
    private int errorCode;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    @Indexed
    private Locale locale;


    public ErrorMessage(){

    }

    public ErrorMessage(int errorCode, String message, Locale locale){
        this.errorCode = errorCode;
        this.message = message;
        this.locale = locale;
    }

}
