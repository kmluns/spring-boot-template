package com.uns.template.service;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.dto.response.ResponseType;
import com.uns.template.model.localization.ErrorMessage;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.service.error.ErrorMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by kmluns
 **/
@Service
public class GenericResponseService {

    @Autowired
    ErrorMessageService errorMessageService;

    public <T> GenericResponse createResponse(ResponseType responseType, String message, T data, int errorCode) {
        GenericResponse<T> response = new GenericResponse<T>()
                .setData(data)
                .setResponseType(responseType)
                .setMessage(message)
                .setErrorCode(errorCode);
        return response;
    }

    public <T> GenericResponse createResponseNoError(String message, T data) {
        return createResponse(ResponseType.SUCCESS,message,data,ErrorMessageConstant.NO_ERROR);
    }

    public <T> GenericResponse createResponseNoError(T data) {
        return createResponse(ResponseType.SUCCESS,null,data,ErrorMessageConstant.NO_ERROR);
    }

    public <T> GenericResponse createResponseWithError(String message) {
        return createResponse(ResponseType.ERROR,message,null,ErrorMessageConstant.UNKNOWN_ERROR);
    }

    public <T> GenericResponse createResponseWithError(String message, T data) {
        return createResponse(ResponseType.ERROR,message,data,ErrorMessageConstant.UNKNOWN_ERROR);
    }
    public <T> GenericResponse createResponseWithError(int errorCode, T data) {
        ErrorMessage errorMessage = errorMessageService.getErrorMessage(errorCode);
        return createResponse(ResponseType.ERROR,errorMessage.getMessage(),data,errorCode);
    }

    public <T> GenericResponse createResponseWithError(int errorCode) {
        ErrorMessage errorMessage = errorMessageService.getErrorMessage(errorCode);
        return createResponse(ResponseType.ERROR,errorMessage.getMessage(),null,errorCode);
    }

    public <T> GenericResponse createResponseWithRedirect(String newURl, T data){
        return createResponse(ResponseType.REDIRECT,newURl,data,ErrorMessageConstant.NO_ERROR);
    }

    public <T> GenericResponse createResponseWithRedirect(String relativeNewURL){
        return createResponse(ResponseType.REDIRECT,relativeNewURL,null,ErrorMessageConstant.NO_ERROR);
    }

}

