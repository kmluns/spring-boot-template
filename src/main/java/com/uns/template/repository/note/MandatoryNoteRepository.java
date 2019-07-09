package com.uns.template.repository.note;

import com.uns.template.model.note.MandatoryNote;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * created by kmluns
 **/
public interface MandatoryNoteRepository extends MongoRepository<MandatoryNote,String> {
}
