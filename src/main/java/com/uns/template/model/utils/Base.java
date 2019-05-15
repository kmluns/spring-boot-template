package com.uns.template.model.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.util.Date;
import java.util.UUID;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
public abstract class Base {

    @Id
    @Getter
    @Setter
    private String id = UUID.randomUUID().toString();

    @CreatedDate
    @Getter
    @Setter
    private Date created;

    @LastModifiedDate
    @Getter
    @Setter
    private Date updated;

    @Version
    @Getter
    @Setter
    private Long version;


    @Getter
    @Setter
    private Boolean delete = Boolean.FALSE;

}
