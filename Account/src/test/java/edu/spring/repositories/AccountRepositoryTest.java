package edu.spring.repositories;

import edu.spring.config.AppConfig;
import edu.spring.entities.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository repository;

    @Test
    public void testGetAccounts() {
        List<Account> accounts = repository.findAll();
        assertThat(accounts.size(), is(3));
    }

    @Test
    public void testGetAccount() {
        Account account = repository.findOne(1L);
        assertThat(account.getId(), is(1L));
        assertThat(new BigDecimal("100.0"),
                is(closeTo(account.getBalance(), new BigDecimal("0.01"))));
    }

    @Test
    public void testGetNumberOfAccounts() {
        assertThat(repository.count(), is(3));
    }

    @Test
    public void testCreateAccount() {
        Account account = new Account(99L, new BigDecimal("250.0"));
        repository.save(account);
        Long id = account.getId();
        assertThat(id, is(notNullValue()));

        Account again = repository.findOne(id);
        assertThat(again.getId(), is(id));
        assertThat(again.getBalance(), is(closeTo(new BigDecimal("250.0"),
                new BigDecimal("0.01"))));
    }

    @Test
    public void testUpdateAccount() {
        Account account = repository.findOne(1L);
        BigDecimal current = account.getBalance();
        BigDecimal amount = new BigDecimal("50.0");
        account.setBalance(current.add(amount));
        repository.save(account);

        Account again = repository.findOne(1L);
        assertThat(again.getBalance(), is(closeTo(current.add(amount),
                new BigDecimal("0.01"))));
    }

    @Test
    public void testDeleteAccount() {
        repository.deleteAll();
        assertThat(repository.count(), is(0));
    }

    @Test
    public void testAccountBalanceGTE() {
        List<Account> accounts = repository.findAccountsByBalanceGreaterThanEqual(
                new BigDecimal("100.0"));
        assertThat(accounts.size(), is(3));
    }
}