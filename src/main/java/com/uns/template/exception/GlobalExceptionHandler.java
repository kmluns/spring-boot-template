package com.uns.template.exception;

import com.mongodb.util.JSONParseException;
import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.service.error.ErrorMessageService;
import com.uns.template.service.GenericResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.InternalParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.security.auth.login.LoginException;

/**
 * created by kmluns
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    // TODO : Errorlarin icerisinde text hazir bulunsun ve databaseden ceksin. Burada bulunmasin
    // TODO : Burada sadece e.getMessage() gibi birsey olsun!!!!

    @Autowired
    GenericResponseService genericResponseService;

    @Autowired
    ErrorMessageService errorMessageService;

    @ExceptionHandler({LoginException.class, AuthenticationException.class})
    public final ResponseEntity<GenericResponse<Object>> loginFailed(Exception e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(errorMessageService.getErrorMessage(ErrorMessageConstant.AUTHENTICATION_ERROR).getMessage(), null),
                HttpStatus.UNAUTHORIZED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InternalParseException.class, JSONParseException.class, HttpMessageNotReadableException.class})
    public final ResponseEntity<GenericResponse<Object>> parseFailed(Exception e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(errorMessageService.getErrorMessage(ErrorMessageConstant.PARSE_ERROR).getMessage(), null),
                HttpStatus.BAD_REQUEST);

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public final ResponseEntity<GenericResponse<Object>> processFailed(Exception e) {
        return new ResponseEntity<>(genericResponseService.createResponseWithError(errorMessageService.getErrorMessage(ErrorMessageConstant.PROCESS_ERROR).getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({BadCredentialsException.class})
    public final ResponseEntity<GenericResponse<Object>> jwtBadCridentialsFailed(Exception e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(errorMessageService.getErrorMessage(ErrorMessageConstant.BAD_CREDENTIALS_ERROR).getMessage(), null),
                HttpStatus.FORBIDDEN);
    }


    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(UsernameExistException.class)
    public final ResponseEntity<GenericResponse<Object>> usernameExist(Exception e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(errorMessageService.getErrorMessage(ErrorMessageConstant.USERNAME_EXIST).getMessage(), null),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({Exception.class, NoHandlerFoundException.class, NotFoundException.class})
    public final ResponseEntity<GenericResponse<Object>> unknownError(Exception e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(errorMessageService.getErrorMessage(ErrorMessageConstant.UNKNOWN_ERROR).getMessage(), null),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({AuthorizationException.class, AccessDeniedException.class})
    public final ResponseEntity<GenericResponse<Object>> authorizationError(Exception e) {
        return new ResponseEntity<GenericResponse<Object>>(genericResponseService.createResponseWithError(errorMessageService.getErrorMessage(ErrorMessageConstant.AUTHORIZATION_ERROR).getMessage(), null),
                HttpStatus.UNAUTHORIZED);

    }

}
