package com.uns.template.exception.runtime;

import lombok.Getter;

/**
 * created by kmluns 21.01.2019
 **/
public class ApplicationRuntimeException extends RuntimeException {

    @Getter
    private int error_code;

    /** Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public ApplicationRuntimeException(String message,int error_code) {
        super(message);
        this.error_code = error_code;
    }

}
