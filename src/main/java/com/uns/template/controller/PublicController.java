package com.uns.template.controller;

import com.uns.template.dto.request.AccountLoginDTO;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.exception.runtime.ParseException;
import com.uns.template.exception.runtime.UsernameExistException;
import com.uns.template.service.AuthenticationService;
import com.uns.template.service.GenericResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * created by kmluns
 **/
@RestController
@RequestMapping
public class PublicController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    GenericResponseService genericResponseService;

    @GetMapping({"/", "index"})
    public GenericResponse index() {
        return genericResponseService.createResponseNoError( "INDEX", "INDEX RESPONSE");
    }

    @PostMapping({"customLogin"})
    public GenericResponse login(@Validated @RequestBody AccountLoginDTO loginDto, Errors errors) {
        if (errors.hasErrors()) {
            throw new ParseException();
        }
        return authenticationService.login(loginDto);
    }


    @GetMapping({"usernameNotExist"})
    public GenericResponse usernameNotExist() {
        throw new UsernameExistException();
    }

}
