package com.uns.template.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
public class GenericResponse<T> {

    @Getter
    @Setter
    private ResponseType responseType;

    @Getter
    @Setter
    private int errorCode;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private T data;

    public GenericResponse(){

    }

    public GenericResponse(ResponseType responseType,int errorCode, String message, T data){
        this.responseType = responseType;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }
}
