package com.uns.template.authorization.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uns.template.model.account.AccountDetail;
import com.uns.template.model.utils.Base;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * created by kmluns
 **/
@Document
@Accessors(chain = true)
@JsonIgnoreProperties({"password", "lastLogin", "accountNonExpired",
        "accountNonLocked", "credentialsNonExpired"})
public class Account extends Base implements UserDetails {

    @Getter
    @Setter
    @Indexed(unique = true)
    @NotNull
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private AccountDetail accountDetail;

    @Getter
    @Setter
    public boolean demo = true;

    @Getter
    @Setter
    private Date finishDate;

    @Getter
    @Setter
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new Role[]{getRole()});
    }

    @Getter
    @Setter
    private Date lastLogin;

    @Getter
    @Setter
    private boolean accountNonExpired = true;

    @Getter
    @Setter
    private boolean accountNonLocked = true;

    @Getter
    @Setter
    private boolean credentialsNonExpired = true;

    @Getter
    @Setter
    public boolean enabled = true;

    public boolean hasRole(Role role) {
        return getAuthorities().contains(role);
    }

    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof Account) {
            return username.equals(((Account) obj).getUsername());
        } else {
            return false;
        }

    }

}
