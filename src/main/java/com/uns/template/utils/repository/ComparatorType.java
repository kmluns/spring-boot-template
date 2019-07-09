package com.uns.template.utils.repository;

public enum ComparatorType {

    EQUALS("equal"),
    GREATER_THAN("greaterThan"),
    LESS_THAN("lessThan");

    private final String text;

    ComparatorType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
