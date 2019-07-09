package com.uns.template.config;

import com.uns.template.authorization.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * created by kmluns
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // @formatter:off
        httpSecurity
                .csrf()
                .disable()
                .formLogin()
                .disable()
                .cors()

//                                                                        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/","/customLogin", "/test/**", "/index", "/register/*", "/activation/*").permitAll()
                .antMatchers("/admin", "/admin/**").hasAuthority(Role.ADMIN.toString())
                .antMatchers("/user", "/user/**").hasAuthority(Role.USER.toString())

//                .authorizeRequests()
//                .antMatchers("/user", "/user/**").hasAuthority(RoleCLass.user().getAuthority())
                .anyRequest()
                .authenticated()
                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/loginError")
//                .defaultSuccessUrl("/loginCorrect",true)
//                .successHandler((req,res,auth)->{    //Success handler invoked after successful authentication
//                    res.sendRedirect("/"); // Redirect user to index/home page
//                    res.addCookie(new Cookie("JSESSION",auth.getCredentials().toString()));
//                })
//                .and()
                .logout()
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
        ;
        // @formatter:on
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return source;
    }


}