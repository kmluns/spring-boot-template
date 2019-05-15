package com.uns.template.controller;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.dto.request.AccountDTO;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.service.AccountService;
import com.uns.template.service.error.ErrorMessageService;
import com.uns.template.service.GenericResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * created by kmluns
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    GenericResponseService genericResponseService;

    @Autowired
    ErrorMessageService errorMessageService;

    @Autowired
    AccountService accountService;

    @GetMapping("errorMessage")
    public GenericResponse errorMessage() {

        return genericResponseService.createResponseWithError(ErrorMessageConstant.PROCESS_ERROR);
    }


    @PostMapping("createAccount")
    public GenericResponse createAccount() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername(UUID.randomUUID().toString())
                .setPassword("12345");

        return accountService.createAccount(accountDTO);
    }


}
