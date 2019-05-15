package com.uns.template.service;

import com.uns.template.authorization.model.Account;
import com.uns.template.authorization.model.Role;
import com.uns.template.dto.request.AccountDTO;
import com.uns.template.model.account.AccountDetail;
import com.uns.template.repository.authorization.AccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created by kmluns
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    private AccountDetail accountDetail;
    private AccountDetail accountDetail2;
    private AccountDTO accountDTO;
    private AccountDTO accountDTO2;


    @Before
    public void init() {
        accountRepository.deleteAll();

        accountDetail = new AccountDetail()
                .setName("kamil")
                .setLastname("unsal")
                .setPhone("9999999999");

       accountDTO = new AccountDTO()
                .setUsername("kmluns")
                .setPassword("12345")
                .setAccountDetail(accountDetail);

        accountDetail2 = new AccountDetail()
                .setName("kamil2")
                .setLastname("unsal")
                .setPhone("9999999999");

        accountDTO2 = new AccountDTO()
                .setUsername("kmluns2")
                .setPassword("12345")
                .setAccountDetail(accountDetail);
    }

    @Test
    public void createAccount() {
        accountService.createAccount(accountDTO);

        Account actualAccount = accountRepository.findByUsername(accountDTO.getUsername());
        Assert.assertNotNull(actualAccount);
        Assert.assertEquals("The name in Account Detail should be same!", accountDetail.getName(), actualAccount.getAccountDetail().getName());
    }


    @Test
    public void countByRoles() {
        accountService.createAccount(accountDTO);
        accountService.createAccount(accountDTO2);

        int countUser = accountService.countByRole(Role.USER);
        int countAdmin = accountService.countByRole(Role.ADMIN);

        Assert.assertEquals("The count should be 2!",2,countUser);
        Assert.assertEquals("The count should be 0!",0,countAdmin);
    }
}
