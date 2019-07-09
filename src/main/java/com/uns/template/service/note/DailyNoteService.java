package com.uns.template.service.note;

import com.uns.template.authorization.model.Account;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.exception.runtime.AuthorizationException;
import com.uns.template.exception.runtime.NotFoundException;
import com.uns.template.model.note.DailyNote;
import com.uns.template.model.note.Note;
import com.uns.template.repository.note.DailyNoteRepository;
import com.uns.template.repository.note.NoteRepository;
import com.uns.template.service.GenericResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * created by kmluns
 **/
@Service
public class DailyNoteService {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DailyNoteRepository dailyNoteRepository;

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    GenericResponseService genericResponseService;

    public GenericResponse createNote(Account account, DailyNote mandatoryNoteDTO) {
        DailyNote dailyNote = modelMapper.map(mandatoryNoteDTO, DailyNote.class);
        dailyNote.setOwner(account);
        dailyNote.setId(UUID.randomUUID().toString());
        dailyNoteRepository.save(dailyNote);
        return genericResponseService.createResponseNoError("", dailyNote);
    }


    public GenericResponse editNote(Account account, DailyNote note) {
        Optional<DailyNote> optionalDailyNote = dailyNoteRepository.findById(note.getId());

        if (optionalDailyNote.isPresent()) {
            DailyNote dailyNote = optionalDailyNote.get();
            if (dailyNote.getOwner().equals(account)) {
                dailyNote.update(note);
                dailyNoteRepository.save(dailyNote);
                return genericResponseService.createResponseNoError("", dailyNote);
            } else {
                throw new AuthorizationException();
            }
        } else {
            throw new NotFoundException();
        }
    }

    public GenericResponse changeType(Account account, DailyNote noteDTO) {

        Optional<Note> optionalNote = noteRepository.findById(noteDTO.getId());
        if(optionalNote.isPresent()){
            Note note = optionalNote.get();
            if(note.getOwner().equals(account)){
                noteRepository.deleteById(note.getId());
                DailyNote dailyNote = modelMapper.map(note,DailyNote.class);
                dailyNoteRepository.save(dailyNote);
                return genericResponseService.createResponseNoError("",dailyNote);
            }else {
                throw new AuthorizationException();
            }
        }else{
            throw new NotFoundException();
        }
    }
}
