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
        httpSecurity.csrf().disable();
//                .headers().frameOptions().disable();
//                                                                        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.cors();

        httpSecurity.authorizeRequests()
                .antMatchers( "/createAccount", "/test/**", "/index", "/login", "/register/*", "/activation/*", "/public/**").permitAll()
                .antMatchers("/admin", "/admin/**").hasAuthority(Role.admin().getAuthority())
                .and()
                .authorizeRequests()
                .antMatchers("/user", "/user/**").hasAuthority(Role.user().getAuthority())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/loginError")
                .defaultSuccessUrl("/loginCorrect",true)
//                .successHandler((req,res,auth)->{    //Success handler invoked after successful authentication
//                    res.sendRedirect("/"); // Redirect user to index/home page
//                    res.addCookie(new Cookie("JSESSION",auth.getCredentials().toString()));
//                })
                .and()
                .logout()
                .logoutUrl("/logout");
        // @formatter:on
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}