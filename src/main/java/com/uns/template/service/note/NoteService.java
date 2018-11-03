package com.uns.template.service.note;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.authorization.model.Account;
import com.uns.template.model.note.DailyNote;
import com.uns.template.model.note.MandatoryNote;
import com.uns.template.model.note.NormalNote;
import com.uns.template.model.note.Note;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.repository.note.NoteRepository;
import com.uns.template.service.GenericResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by kmluns
 **/
@Service
public class NoteService {

    @Autowired
    GenericResponseService genericResponseService;

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    DailyNoteService dailyNoteService;

    @Autowired
    NormalNoteService normalNoteService;

    @Autowired
    MandatoryNoteService mandatoryNoteService;


    public GenericResponse create(Account account, Note noteDTO) {

        switch (noteDTO.getType()) {
            case DAILY:
                return dailyNoteService.createNote(account,(DailyNote) noteDTO);
            case NORMAL:
                return normalNoteService.createNote(account,(NormalNote) noteDTO);
            case MANDATORY:
                return mandatoryNoteService.createNote(account,(MandatoryNote) noteDTO);
            default:
                return genericResponseService.createResponseWithError(ErrorMessageConstant.PROCESS_ERROR);
        }
    }

    public GenericResponse edit(Account account, Note noteDTO){
        switch (noteDTO.getType()) {
            case DAILY:
                return dailyNoteService.editNote(account,(DailyNote) noteDTO);
            case NORMAL:
                return normalNoteService.editNote(account,(NormalNote) noteDTO);
            case MANDATORY:
                return mandatoryNoteService.editNote(account,(MandatoryNote) noteDTO);
            default:
                return genericResponseService.createResponseWithError(ErrorMessageConstant.PROCESS_ERROR);
        }
    }

    public GenericResponse changeType(Account account, Note noteDTO){
        switch (noteDTO.getType()) {
            case DAILY:
                return dailyNoteService.changeType(account,(DailyNote) noteDTO);
            case NORMAL:
                return normalNoteService.changeType(account,(NormalNote) noteDTO);
            case MANDATORY:
                return mandatoryNoteService.changeType(account,(MandatoryNote) noteDTO);
            default:
                return genericResponseService.createResponseWithError(ErrorMessageConstant.PROCESS_ERROR);
        }
    }


    public GenericResponse count() {
        return genericResponseService.createResponseNoError("",noteRepository.count());
    }

    public GenericResponse all() {
        return genericResponseService.createResponseNoError("",noteRepository.findAll());
    }
}
