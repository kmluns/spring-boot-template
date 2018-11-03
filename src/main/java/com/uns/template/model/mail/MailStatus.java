package com.uns.template.model.mail;

/**
 * created by kmluns
 **/
public enum MailStatus {
    SENT("SENT"),
    PENDING("PENDING"),
    ERROR("ERROR");

    private final String text;

    MailStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
