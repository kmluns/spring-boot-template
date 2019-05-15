package com.uns.template.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.mail.Store;

/**
 * created by kmluns
 **/
@Configuration
public class MailConfig {

    @Autowired
    Environment environment;

    @Bean
    public Store store() {

        //TODO mail has to be enable
//        Properties prop = new Properties();
//        prop.put("mail.pop3.host", environment.getProperty("mail.pop3.host"));
//        prop.put("mail.pop3.port", environment.getProperty("mail.pop3.port"));
//        prop.put("mail.pop3.username", environment.getProperty("mail.pop3.username"));
//        prop.put("mail.pop3.password", environment.getProperty("mail.pop3.password"));
//        prop.put("mail.smtp.socketFactory.class", environment.getProperty("mail.class"));
//
//        Session session = Session.getInstance(prop);
//        try {
//            Store store = session.getStore("pop3s");
//
//            store.connect(
//                    environment.getProperty("mail.pop3.host"),
//                    environment.getProperty("mail.pop3.username"),
//                    environment.getProperty("mail.pop3.password"));
//
//            return store;
//
//        } catch (NoSuchProviderException e) {
//            System.out.println(e);
//        } catch (MailConnectException e) {
//            System.out.println(e);
//        } catch (MessagingException e) {
//            System.out.println(e);
//        }

        return null;
    }
}
