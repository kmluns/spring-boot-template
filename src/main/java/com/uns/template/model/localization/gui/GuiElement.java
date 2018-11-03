package com.uns.template.model.localization.gui;

/**
 * created by kmluns
 **/
public enum GuiElement {
    BUTTON("BUTTON"),
    TABLE_HEADER("TABLE_HEADER"),
    NAV_BAR("NAV_BAR");

    private final String text;

    GuiElement(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
