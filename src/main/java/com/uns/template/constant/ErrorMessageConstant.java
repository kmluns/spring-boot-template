package com.uns.template.constant;

/**
 * created by kmluns
 **/
public class ErrorMessageConstant {


    // "Hata yok"
    public static final int NO_ERROR = -1;

    // "Kullanıcı adı ve ya şifre hatalı!"
    public static final int AUTHENTICATION_ERROR = 1;

    // "Bilgilerinizde hata var!"
    public static final int PARSE_ERROR = 2;

    // "İşleminizi gerçekleştirirken bir problem oluştu. Lütfen yeniden deneyiniz."
    public static final int PROCESS_ERROR = 3;

    // "Oturum suresiniz sona ermiştir, lütfen yeniden giris yapınız."
    public static final int JWT_EXPIRED_ERROR = 4;

    //  "Giris Yapmalisiniz!!"
    public static final int BAD_CREDENTIALS_ERROR = 5;

    // "Kullanici ismi bulunmaktadir"
    public static final int USERNAME_EXIST = 6;





    // "Bulunamadı!"
    public static final int NOT_FOUND = 404;

    // "Authorization ERROR"
    public static final int AUTHORIZATION_ERROR = 401;





    // "Bilinmeyen Hata"
    public static final int UNKNOWN_ERROR = 999;

}
