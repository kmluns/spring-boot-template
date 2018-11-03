package com.uns.template.authorization.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

/**
 * created by kmluns
 **/
@Accessors(chain = true)
public class Role implements GrantedAuthority {

    @Getter
    @Setter
    private String authority;

    public static Role user() {
        return new Role()
                .setAuthority("ROLE_USER");
    }

    public static Role organization() {
        return new Role()
                .setAuthority("ROLE_ORGANIZATION");
    }

    public static Role admin() {
        return new Role()
                .setAuthority("ROLE_ADMIN");
    }

    @Override
    public int hashCode() {
        return authority.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Role) {
            return getAuthority().equals(((Role) obj).getAuthority());
        } else {
            return false;
        }
    }

}
