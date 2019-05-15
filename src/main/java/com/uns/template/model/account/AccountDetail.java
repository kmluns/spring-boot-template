package com.uns.template.model.account;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
public class AccountDetail {

    @Getter
    @Setter
    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @Getter
    @Setter
    @NotNull
    @Size(min = 1, max = 50)
    private String lastname;

    @Getter
    @Setter
    @NotNull
    @Pattern(regexp = "\\d{3}-? ?\\d{3}-? ?\\d{2}-? ?\\d{2}$")
    private String phone;
}
