package com.uns.template.dto.request;

import com.uns.template.model.account.AccountDetail;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import javax.validation.constraints.Email;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
public class AccountDTO {

    @Email
    @Getter
    @Setter
    @NotNull
    @Size(min = 5, max = 100)
    private String username;

    @Getter
    @Setter
    @NotNull
    @Size(min = 8, max = 50)
    private String password;

    @Valid
    @Getter
    @Setter
    private AccountDetail accountDetail;
}
