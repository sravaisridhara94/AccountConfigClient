package com.example.accountservice.repository;

import com.example.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Account Service Repository
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
