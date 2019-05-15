package com.uns.template.config;

import com.uns.template.utils.EmailUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by kmluns
 **/
@Configuration
public class BeanConfig {

    @Bean
    public EmailUtils userDomain() {
        return new EmailUtils();
    }

    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}

}
