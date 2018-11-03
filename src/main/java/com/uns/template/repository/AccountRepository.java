package com.uns.template.repository;

import com.uns.template.authorization.model.Account;
import com.uns.template.authorization.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * created by kmluns
 **/
public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByUsername(String username);

    int countByRole(Role role);

    List<Account> findByDemoAndFinishDateLessThanAndAccountNonExpired(Boolean isDemo, Date period, Boolean isAccountNonExpired);

}
