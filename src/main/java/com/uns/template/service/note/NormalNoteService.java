package com.uns.template.service.note;

import com.uns.template.authorization.model.Account;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.exception.runtime.AuthorizationException;
import com.uns.template.exception.runtime.NotFoundException;
import com.uns.template.model.note.NormalNote;
import com.uns.template.model.note.Note;
import com.uns.template.repository.note.NormalNoteRepository;
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
public class NormalNoteService {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NormalNoteRepository normalNoteRepository;

    @Autowired
    GenericResponseService genericResponseService;

    @Autowired
    NoteRepository noteRepository;

    public GenericResponse createNote(Account account, NormalNote mandatoryNoteDTO) {
        NormalNote normalNote = modelMapper.map(mandatoryNoteDTO, NormalNote.class);
        normalNote.setOwner(account);
        normalNote.setId(UUID.randomUUID().toString());
        normalNoteRepository.save(normalNote);
        return genericResponseService.createResponseNoError("", normalNote);
    }

    public GenericResponse editNote(Account account, NormalNote note) {
        Optional<NormalNote> optionalDailyNote = normalNoteRepository.findById(note.getId());

        if (optionalDailyNote.isPresent()) {
            NormalNote normalNote = optionalDailyNote.get();
            if (normalNote.getOwner().equals(account)) {
                normalNote.update(note);
                normalNoteRepository.save(normalNote);
                return genericResponseService.createResponseNoError("", normalNote);
            } else {
                throw new AuthorizationException();
            }
        } else {
            throw new NotFoundException();
        }
    }

    public GenericResponse changeType(Account account, NormalNote noteDTO) {

        Optional<Note> optionalNote = noteRepository.findById(noteDTO.getId());
        if(optionalNote.isPresent()){
            Note note = optionalNote.get();
            if(note.getOwner().equals(account)){
                noteRepository.deleteById(note.getId());
                NormalNote normalNote = modelMapper.map(note,NormalNote.class);
                normalNoteRepository.save(normalNote);
                return genericResponseService.createResponseNoError("",normalNote);
            }else {
                throw new AuthorizationException();
            }
        }else{
            throw new NotFoundException();
        }
    }
}
