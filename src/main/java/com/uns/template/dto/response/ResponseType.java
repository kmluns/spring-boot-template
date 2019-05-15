package com.uns.template.dto.response;

/**
 * created by kmluns 21.01.2019
 **/
public enum ResponseType {

    ERROR("ERROR"),
    REDIRECT("REDIRECT"),
    SUCCESS("SUCCESS")
    ;

    private final String text;

    ResponseType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
