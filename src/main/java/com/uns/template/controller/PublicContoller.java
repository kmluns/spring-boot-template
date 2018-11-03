package com.uns.template.controller;

import com.uns.template.authorization.model.Account;
import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.dto.request.AccountLoginDTO;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.service.AccountService;
import com.uns.template.service.AuthenticationService;
import com.uns.template.service.GenericResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * created by kmluns
 **/
@RestController
@RequestMapping
public class PublicContoller {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    GenericResponseService genericResponseService;

    @GetMapping({"/", "index"})
    public GenericResponse index() {
        return new GenericResponse(false, -1, "INDEX", "INDEX RESPONSE");
    }

    @PostMapping({"customLogin" })
    public GenericResponse login(@Validated @RequestBody AccountLoginDTO loginDto, Errors errors) {
        if (errors.hasErrors()) {
            return genericResponseService.createResponseWithError(ErrorMessageConstant.PARSE_ERROR);
        }
        return authenticationService.login(loginDto);
    }

}
