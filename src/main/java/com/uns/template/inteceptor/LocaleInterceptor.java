package com.uns.template.inteceptor;

import com.uns.template.model.localization.Locale;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created by kmluns
 **/
@Component
public class LocaleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie langCookie = WebUtils.getCookie(request,"lang");
        Locale locale;
        if(langCookie != null){
            try {
                locale = Locale.valueOf(langCookie.getValue());
            }
            catch (Exception e){
                locale = Locale.en;
            }
        }else{
            locale = Locale.en;
            response.addCookie(new Cookie("lang",Locale.en.toString()));
        }

        LocaleContextHolder.setLocale(new java.util.Locale(locale.toString()));
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
    }
}