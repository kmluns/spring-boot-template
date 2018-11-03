package com.uns.template.authorization;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

/**
 * created by kmluns
 **/
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@PreAuthorize("hasRole(T(com.uns.template.authorization.model.Role).admin().getAuthority())")
public @interface AdminAuthorization {
}
