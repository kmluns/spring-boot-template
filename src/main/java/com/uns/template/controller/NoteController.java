package com.uns.template.controller;

import com.uns.template.authorization.AdminAuthorization;
import com.uns.template.authorization.model.Account;
import com.uns.template.model.note.Note;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by kmluns
 **/
@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    NoteService noteService;


    @PostMapping("create")
    public GenericResponse create(@AuthenticationPrincipal Account account, Note noteDTO) {
        return noteService.create(account, noteDTO);
    }

    @PostMapping("edit")
    public GenericResponse edit(@AuthenticationPrincipal Account account, Note noteDTO) {
        return noteService.edit(account, noteDTO);
    }

    @PostMapping("changeType")
    public GenericResponse changeType(@AuthenticationPrincipal Account account, Note noteDTO) {
        return noteService.changeType(account, noteDTO);
    }

    @AdminAuthorization
    @PostMapping("count")
    public GenericResponse count() {
        return noteService.count();
    }

    @AdminAuthorization
    @PostMapping("all")
    public GenericResponse all() {
        return noteService.all();
    }

}
