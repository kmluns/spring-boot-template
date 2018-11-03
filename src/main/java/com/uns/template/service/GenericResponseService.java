package com.uns.template.service;

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

    public <T> GenericResponse createResponse(boolean err, String message, T data) {
        GenericResponse<T> response = new GenericResponse<>();
        response.setData(data).setError(err).setMessage(message);
        return response;
    }

    public <T> GenericResponse createResponseNoError(String message, T data) {
        GenericResponse<T> response = new GenericResponse<>();
        response.setData(data).setError(false).setMessage(message);
        return response;
    }

    public <T> GenericResponse createResponseWithError(String message, T data) {
        GenericResponse<T> response = new GenericResponse<>();
        response.setData(data).setError(true).setMessage(message);
        return response;
    }

    public <T> GenericResponse createResponseWithError(int errorCode, T data) {

        ErrorMessage errorMessage = errorMessageService.getErrorMessage(errorCode);


        GenericResponse<T> response = new GenericResponse<>();
        response.setData(data).setError(true).setMessage(errorMessage.getMessage());
        return response;
    }

    public <T> GenericResponse createResponseWithError(int errorCode) {

        ErrorMessage errorMessage = errorMessageService.getErrorMessage(errorCode);


        GenericResponse<T> response = new GenericResponse<>();
        response.setData(null).setError(true).setMessage(errorMessage.getMessage());
        return response;
    }

}

