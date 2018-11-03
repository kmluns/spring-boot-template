package com.uns.template.service.error;

import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.model.localization.ErrorMessage;
import com.uns.template.model.localization.Locale;
import com.uns.template.repository.localization.ErrorMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;

/**
 * created by kmluns
 **/

@Service
public class ErrorMessageDataService {

    @Autowired
    ErrorMessageRepository errorMessageRepository;

    @PostConstruct
    public void createErrorMessages(){

        //errorMessageRepository.deleteAll();

        if(errorMessageRepository.count() == 0) {
            LinkedList<ErrorMessage> errorMessages = new LinkedList<>();

            errorMessages.add(new ErrorMessage(ErrorMessageConstant.UNKNOWN_ERROR, "Unknown Error!", Locale.en));
            errorMessages.add(new ErrorMessage(ErrorMessageConstant.UNKNOWN_ERROR, "Bilinmeyen Hata!", Locale.tr));

            errorMessages.add(new ErrorMessage(ErrorMessageConstant.AUTHENTICATION_ERROR, "Username or password wrong!", Locale.en));
            errorMessages.add(new ErrorMessage(ErrorMessageConstant.AUTHENTICATION_ERROR, "Kullanıcı adı ve ya şifre hatalı!", Locale.tr));

            errorMessages.add(new ErrorMessage(ErrorMessageConstant.PARSE_ERROR, "Something wrong in your information!", Locale.en));
            errorMessages.add(new ErrorMessage(ErrorMessageConstant.PARSE_ERROR, "Bilgilerinizde hata var!", Locale.tr));

            errorMessages.add(new ErrorMessage(ErrorMessageConstant.PROCESS_ERROR, "Something happened while process. Please try again", Locale.en));
            errorMessages.add(new ErrorMessage(ErrorMessageConstant.PROCESS_ERROR, "İşleminizi gerçekleştirirken bir problem oluştu. Lütfen yeniden deneyiniz.", Locale.tr));

            errorMessages.add(new ErrorMessage(ErrorMessageConstant.JWT_EXPIRED_ERROR, "Your session has been expiredö, please login again.", Locale.en));
            errorMessages.add(new ErrorMessage(ErrorMessageConstant.JWT_EXPIRED_ERROR, "Oturum suresiniz sona ermiştir, lütfen yeniden giris yapınız.", Locale.tr));

            errorMessages.add(new ErrorMessage(ErrorMessageConstant.BAD_CREDENTIALS_ERROR, "You have to login!", Locale.en));
            errorMessages.add(new ErrorMessage(ErrorMessageConstant.BAD_CREDENTIALS_ERROR, "Giriş Yapmalısınız!", Locale.tr));

            errorMessages.add(new ErrorMessage(ErrorMessageConstant.USERNAME_EXIST, "The username already using!", Locale.en));
            errorMessages.add(new ErrorMessage(ErrorMessageConstant.USERNAME_EXIST, "Kullanici ismi zaten kullanılmaktadır!", Locale.tr));

            errorMessages.add(new ErrorMessage(ErrorMessageConstant.NOT_FOUND, "Nothing found, something wrong!", Locale.en));
            errorMessages.add(new ErrorMessage(ErrorMessageConstant.NOT_FOUND, "Bulunamadı, Birşeyler yanlış!", Locale.tr));

            errorMessages.add(new ErrorMessage(ErrorMessageConstant.AUTHORIZATION_ERROR, "You are not authorized!", Locale.en));
            errorMessages.add(new ErrorMessage(ErrorMessageConstant.AUTHORIZATION_ERROR, "Yetkiniz bulunmamaktadır!", Locale.tr));

            errorMessageRepository.saveAll(errorMessages);
        }
    }

}
