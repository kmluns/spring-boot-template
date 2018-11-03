package com.uns.template.model.note;

import com.uns.template.authorization.model.Account;
import com.uns.template.model.utils.Base;
import com.uns.template.model.utils.Priority;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
@Document(collection = "note")
public abstract class Note extends Base {

    @Getter
    @Setter
    private Priority priority = Priority.NORMAL;

    @Getter
    @Setter
    @NotNull
    private String header = "";

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    @DBRef(lazy = true)
    private List<Account> relevantAccounts;

    @Getter
    @Setter
    @NotNull
    @DBRef(lazy = true)
    private Account owner;


    public Note(Account owner) {
        this.owner = owner;
    }

    public void addRelevant(Account relevant) {
        relevantAccounts.add(relevant);
    }


    public abstract NoteType getType();

    public void edit(Note note){
        this.header = note.getHeader();
        this.message = note.getMessage();
        this.priority = note.getPriority();
        this.relevantAccounts = note.getRelevantAccounts();
    }


}
