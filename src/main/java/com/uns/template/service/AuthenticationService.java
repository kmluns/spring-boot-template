package com.uns.template.service;

import com.uns.template.authorization.model.Account;
import com.uns.template.constant.ErrorMessageConstant;
import com.uns.template.dto.request.AccountLoginDTO;
import com.uns.template.dto.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * created by kmluns
 **/
@Service
public class AuthenticationService {

    @Autowired
    AccountService accountService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    GenericResponseService genericResponseService;

    public GenericResponse login(AccountLoginDTO loginDto) {

        Account account = accountService.loadUserByUsername(loginDto.getUsername());
        if (account != null && bCryptPasswordEncoder.matches(loginDto.getPassword(), account.getPassword())) {
            Authentication auth = new UsernamePasswordAuthenticationToken(account, null, account.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            return genericResponseService.createResponseNoError("",SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }

        return genericResponseService.createResponseWithError(ErrorMessageConstant.AUTHENTICATION_ERROR);
    }
}
