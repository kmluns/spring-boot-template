package com.uns.template.controller;

import com.uns.template.dto.response.GenericResponse;
import com.uns.template.service.GenericResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by kmluns 15.05.2019
 **/
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    GenericResponseService genericResponseService;


    @GetMapping({""})
    public GenericResponse dashboard(){

        return genericResponseService.createResponseNoError("ADMIN",null);
    }

}
