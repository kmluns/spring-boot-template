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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.*;

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
    @NotNull
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new LinkedList<>();

        for (Role role : this.getRoles()) {
            simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(role.toString()));
        }

        return simpleGrantedAuthorityList;
    }

    public boolean hasRole(Role role) {
        return getRoles().contains(role);
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

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Account) {
            return username.equals(((Account) obj).getUsername());
        } else {
            return false;
        }

    }

}
