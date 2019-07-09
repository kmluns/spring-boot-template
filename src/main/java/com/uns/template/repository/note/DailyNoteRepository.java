package com.uns.template.repository.note;

import com.uns.template.model.note.DailyNote;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * created by kmluns
 **/
public interface DailyNoteRepository extends MongoRepository<DailyNote,String> {
}
