package com.uns.template.model.mail;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
public class Mail<T> {


    @Getter
    @Setter
    private Date actual;

    @Getter
    @Setter
    private MailStatus sent = MailStatus.PENDING;

    @Getter
    @Setter
    private T data;

    @Getter
    @Setter
    private MailType mailType;

    @Getter
    @Setter
    private int tryCount = 0;


    @Getter
    @Setter
    private boolean sentFail = false;

    @Getter
    @Setter
    private Date estimated;
}
