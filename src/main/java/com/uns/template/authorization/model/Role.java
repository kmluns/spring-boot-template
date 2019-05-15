package com.uns.template.authorization.model;

/**
 * created by kmluns 15.05.2019
 **/
public enum Role {

    ADMIN("ADMIN"),
    USER("USER");

    private final String text;

    /**
     * @param text
     */
    Role(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
