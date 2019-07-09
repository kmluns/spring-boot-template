package com.uns.template.repository.note;

import com.uns.template.model.note.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * created by kmluns
 **/
public interface NoteRepository extends MongoRepository<Note,String> {


}
