package com.uns.template.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
public class PasswordChangeDTO {

    @Getter
    @Setter
    @NotNull
    @Size(min = 8, max = 50)
    private String oldPassword;

    @Getter
    @Setter
    @NotNull
    @Size(min = 8, max = 50)
    private String newPassword;

}