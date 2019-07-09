package com.uns.template.repository.note;

import com.uns.template.model.note.NormalNote;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * created by kmluns
 **/
public interface NormalNoteRepository extends MongoRepository<NormalNote,String> {
}
