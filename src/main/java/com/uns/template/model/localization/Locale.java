package com.uns.template.model.localization;

/**
 * created by kmluns
 **/
public enum Locale {
    en("en"),
    tr("tr");

    private final String text;

    Locale(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}