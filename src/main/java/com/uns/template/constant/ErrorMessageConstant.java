package com.uns.template.constant;

/**
 * created by kmluns
 **/
public class ErrorMessageConstant {

    // "Bilinmeyen Hata"
    public static final int UNKNOWN_ERROR = -1;

    // "Kullanıcı adı ve ya şifre hatalı!"
    public static final int AUTHENTICATION_ERROR = 0;


    // "Bilgilerinizde hata var!"
    public static final int PARSE_ERROR = 1;

    // "İşleminizi gerçekleştirirken bir problem oluştu. Lütfen yeniden deneyiniz."
    public static final int PROCESS_ERROR = 2;

    // "Oturum suresiniz sona ermiştir, lütfen yeniden giris yapınız."
    public static final int JWT_EXPIRED_ERROR = 3;

    //  "Giris Yapmalisiniz!!"
    public static final int BAD_CREDENTIALS_ERROR = 4;

    // "Kullanici ismi bulunmaktadir"
    public static final int USERNAME_EXIST = 5;

    // "Bulunamadı!"
    public static final int NOT_FOUND = 404;

    // "Authorization error"
    public static final int AUTHORIZATION_ERROR = 401;

}
