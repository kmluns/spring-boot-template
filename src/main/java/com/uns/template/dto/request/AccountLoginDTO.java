package com.uns.template.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
public class AccountLoginDTO {

    @Email
    @Getter
    @Setter
    @NotNull
    @Size(min = 4,max = 128)
    private String username;

    @Getter
    @Setter
    @NotNull
    @Size(min = 5,max = 16)
    private String password;

}
