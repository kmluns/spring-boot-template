package com.uns.template.service.note;

import com.uns.template.authorization.model.Account;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.exception.runtime.AuthorizationException;
import com.uns.template.exception.runtime.NotFoundException;
import com.uns.template.model.note.MandatoryNote;
import com.uns.template.model.note.Note;
import com.uns.template.repository.note.MandatoryNoteRepository;
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
public class MandatoryNoteService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MandatoryNoteRepository mandatoryNoteRepository;

    @Autowired
    GenericResponseService genericResponseService;

    @Autowired
    NoteRepository noteRepository;

    public GenericResponse createNote(Account account, MandatoryNote mandatoryNoteDTO) {
        MandatoryNote mandatoryNote = modelMapper.map(mandatoryNoteDTO, MandatoryNote.class);
        mandatoryNote.setOwner(account);
        mandatoryNote.setId(UUID.randomUUID().toString());
        mandatoryNoteRepository.save(mandatoryNote);
        return genericResponseService.createResponseNoError("", mandatoryNote);
    }

    public GenericResponse editNote(Account account, MandatoryNote note) {
        Optional<MandatoryNote> optionalDailyNote = mandatoryNoteRepository.findById(note.getId());

        if (optionalDailyNote.isPresent()) {
            MandatoryNote normalNote = optionalDailyNote.get();
            if (normalNote.getOwner().equals(account)) {
                normalNote.update(note);
                mandatoryNoteRepository.save(normalNote);
                return genericResponseService.createResponseNoError("", normalNote);
            } else {
                throw new AuthorizationException();
            }
        } else {
            throw new NotFoundException();
        }
    }

    public GenericResponse changeType(Account account, MandatoryNote noteDTO) {
        Optional<Note> optionalNote = noteRepository.findById(noteDTO.getId());
        if(optionalNote.isPresent()){
            Note note = optionalNote.get();
            if(note.getOwner().equals(account)){
                noteRepository.deleteById(note.getId());
                MandatoryNote mandatoryNote = modelMapper.map(note,MandatoryNote.class);
                mandatoryNoteRepository.save(mandatoryNote);
                return genericResponseService.createResponseNoError("",mandatoryNote);
            }else {
                throw new AuthorizationException();
            }
        }else{
            throw new NotFoundException();
        }
    }
}
