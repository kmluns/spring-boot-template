package com.uns.template.utils;

import com.uns.template.model.mail.Mail;
import com.uns.template.model.mail.SMTPConfig;
import com.uns.template.exception.runtime.EmailFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.mail.Address;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import java.util.Properties;

/**
 * created by kmluns
 **/
@Component
public class EmailUtils {

    @Autowired
    Environment environment;

    public static String getDomain(String email) throws EmailFormatException {
        try {
            String[] temp = email.split("@");
            return temp[1];
        } catch (Exception exc) {
            throw new EmailFormatException(email);
        }
    }

    public static String getDomain(Address address) {
        InternetAddress internetAddress = (InternetAddress) address;

        return getDomain(internetAddress.getAddress());
    }

    public JavaMailSender getMailSender(Mail mail) {
        SMTPConfig smtpConfig = new SMTPConfig();
        smtpConfig.setHost(environment.getProperty("mail.host"))
                .setPort(Integer.parseInt(environment.getProperty("mail.port")))
                .setUsername(environment.getProperty("mail.username"))
                .setPassword(environment.getProperty("mail.password"))
                .setSslEnable(Boolean.parseBoolean(environment.getProperty("mail.ssl-enable")));

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpConfig.getHost());
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.port", smtpConfig.getPort());
        props.put("mail.smtp.socketFactory.port", smtpConfig.getPort());

        if (smtpConfig.isSslEnable()) {
            props.put("mail.smtp.socketFactory.class", environment.getProperty("mail.class"));
        }

        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(smtpConfig.getUsername(),
                                smtpConfig.getPassword());
                    }
                });

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setSession(session);

        return mailSender;
    }
}