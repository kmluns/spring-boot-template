package com.uns.template.model.note;

/**
 * created by kmluns
 **/
public enum NoteType {
    DAILY("DAILY"),
    NORMAL("NORMAL"),
    MANDATORY("MANDATORY");

    private final String text;

    NoteType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
