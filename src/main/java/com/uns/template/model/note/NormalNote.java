package com.uns.template.model.note;

import com.uns.template.authorization.model.Account;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
@Document(collection = "note")
@TypeAlias("NormalNote")
public class NormalNote extends Note {

    @Getter
    private NoteType type = NoteType.NORMAL;

    public NormalNote(Account owner) {
        super(owner);
    }
}
