package com.uns.template.service;

import com.uns.template.authorization.model.Account;
import com.uns.template.authorization.model.Role;
import com.uns.template.dto.request.AccountDTO;
import com.uns.template.dto.response.GenericResponse;
import com.uns.template.exception.UsernameExistException;
import com.uns.template.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * created by kmluns
 **/
@Service
public class AccountService implements UserDetailsService {

    @Autowired
    GenericResponseService genericResponseService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ModelMapper modelMapper;


    public GenericResponse createAccount(AccountDTO accountDTO) {

        if (usernameExists(accountDTO.getUsername())) {
            throw new UsernameExistException();
        }

        Account account = modelMapper.map(accountDTO, Account.class);
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()))
                .setRole(Role.user());
        account.setId(UUID.randomUUID().toString());

        if (accountRepository.save(account) != null) {
            return genericResponseService.createResponseNoError("", account);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Account loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Kullanıcı Adı/Şifre Yanlış");
        } else {
            return account;
        }
    }

    public void autologin(String username) {
        Account account = loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(account, account.getPassword(), account.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }

    public boolean delete(Account currentAccount, String username) {

        if (accountRepository.findByUsername(username) != null) {
            Account account = accountRepository
                    .findByUsername(username);

            if (!currentAccount.getId().equals(account.getId())) {
                accountRepository.delete(account);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean changePassword(String username, String passwordOld, String passwordNew, boolean isPasswordSet) {
        Account account = accountRepository.findByUsername(username);

        if (isPasswordSet || bCryptPasswordEncoder.matches(passwordOld, account.getPassword())) {
            account.setPassword(bCryptPasswordEncoder.encode(passwordNew));
            account.setEnabled(true);
            accountRepository.save(account);

            return true;
        } else {
            return false;
        }
    }

    public boolean usernameExists(String username) {
        return accountRepository
                .findByUsername(username) != null;
    }

    public boolean isDemo(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            return account.get().isDemo();
        }

        return false;
    }

    public int countByRole(Role role) {
        return accountRepository.countByRole(role);
    }


}
