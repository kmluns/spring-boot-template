package com.uns.template.config;

import com.uns.template.authorization.model.Role;
import com.uns.template.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.SessionManagementFilter;

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

    @Bean
    CorsFilter corsFilter() { return new CorsFilter(); }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // @formatter:off
        httpSecurity.csrf().disable()
                .addFilterBefore(corsFilter(), SessionManagementFilter.class)
//                .headers().frameOptions().disable();
//                                                                        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;


//        List<Word> words = wordRepository.findAll();
//
//        for(Word word : words){
//            httpSecurity.authorizeRequests()
//                    .antMatchers(work.getText())
//                    .hasAnyAuthority(word.getText());
//        }

        httpSecurity.authorizeRequests()
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

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//
//
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", configuration);
//        return source;
//
//
//        return source;
//    }
}