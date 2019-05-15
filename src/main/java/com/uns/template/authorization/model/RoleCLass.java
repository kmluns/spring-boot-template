//package com.uns.template.authorization.model;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.experimental.Accessors;
//import org.springframework.security.core.GrantedAuthority;
//
///**
// * created by kmluns
// **/
//@Accessors(chain = true)
//public class RoleCLass implements GrantedAuthority {
//
//    @Getter
//    @Setter
//    private String authority;
//
//    public static RoleCLass user() {
//        return new RoleCLass()
//                .setAuthority("ROLE_USER");
//    }
//
//    public static RoleCLass organization() {
//        return new RoleCLass()
//                .setAuthority("ROLE_ORGANIZATION");
//    }
//
//    public static RoleCLass admin() {
//        return new RoleCLass()
//                .setAuthority("ROLE_ADMIN");
//    }
//
//    @Override
//    public int hashCode() {
//        return authority.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj != null && obj instanceof RoleCLass) {
//            return getAuthority().equals(((RoleCLass) obj).getAuthority());
//        } else {
//            return false;
//        }
//    }
//
//}
