package com.uns.template.controller;

import com.uns.template.authorization.model.Account;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.service.GenericResponseService;
import com.uns.template.service.upload.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * created by kmluns
 **/
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    Environment environment;

    @Autowired
    ImageUploadService imageUploadService;

    @Autowired
    GenericResponseService genericResponseService;

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "upload-image", params = {"id"})
    public GenericResponse uploadImage(@AuthenticationPrincipal Account account, @RequestBody MultipartFile file, @RequestParam("id") String id) {
        if (imageUploadService.storeImageFile(account, file)) {
            return genericResponseService.createResponseNoError("SUCCESS!", null);
        } else {
            return genericResponseService.createResponseWithError("FAILED!", null);
        }
    }
}