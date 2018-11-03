package com.uns.template.repository;

import com.uns.template.authorization.model.Account;
import com.uns.template.authorization.model.Role;
import com.uns.template.model.note.MandatoryNote;
import com.uns.template.model.note.NormalNote;
import com.uns.template.model.note.Note;
import com.uns.template.repository.note.MandatoryNoteRepository;
import com.uns.template.repository.note.NormalNoteRepository;
import com.uns.template.repository.note.NoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * created by kmluns
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteRepositoryTest {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    NormalNoteRepository normalNoteRepository;

    @Autowired
    MandatoryNoteRepository mandatoryNoteRepository;

    Account account;

    @Before
    public void init() {

        accountRepository.deleteAll();
        noteRepository.deleteAll();

        account = new Account();
        account.setPassword(bCryptPasswordEncoder.encode("12345"))
                .setUsername("kmluns")
                .setRole(Role.user());
        accountRepository.save(account);
    }

    @Test
    public void testInheritence() {

        account = accountRepository.findByUsername("kmluns");

        MandatoryNote mandatoryNote = new MandatoryNote(account);
        mandatoryNote.setMessage("Mandatory");
        mandatoryNoteRepository.insert(mandatoryNote);

        NormalNote normalNote = new NormalNote(account);
        normalNote.setMessage("Normal");
        normalNoteRepository.insert(normalNote);

        List<MandatoryNote> mandaNotes = mandatoryNoteRepository.findAll();

        assertTrue(1 == mandaNotes.size());

        List<NormalNote> normalNotes = normalNoteRepository.findAll();

        assertTrue(1 == normalNotes.size());

        List<Note> notes = noteRepository.findAll();

        assertTrue(2 == notes.size());


    }


}