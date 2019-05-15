package com.uns.template.model.mail;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
public class SMTPConfig {

    @Getter
    @Setter
    private String host;

    @Getter
    @Setter
    private int port;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private boolean sslEnable = false;
}
