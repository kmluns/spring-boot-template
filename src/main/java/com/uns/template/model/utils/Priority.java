package com.uns.template.model.utils;

/**
 * created by kmluns
 **/
public enum Priority {
    IMPORTANT("IMPORTANT"),
    NORMAL("NORMAL");

    private final String text;

    Priority(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}