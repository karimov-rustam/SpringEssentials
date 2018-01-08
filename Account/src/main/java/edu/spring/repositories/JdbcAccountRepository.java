package edu.spring.repositories;

import edu.spring.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Profile("test")
public class JdbcAccountRepository implements AccountRepository {
    private JdbcTemplate template;
    private static long nextId = 4;

    @Autowired
    public JdbcAccountRepository(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Account> getAccounts() {
        String sqlTxt = "select * from account";
        return template.query(sqlTxt, new AccounMapper());
    }

    @Override
    public Account getAccount(Long id) {
        String sqlTxt = "select * from account where id=?";
        return template.queryForObject(sqlTxt, new AccounMapper(), id);
    }

    @Override
    public int getNumberOfAccounts() {
        return 0;
    }

    @Override
    public Long createAccount(BigDecimal initialBalance) {
        return null;
    }

    @Override
    public int deleteAccount(Long id) {
        return 0;
    }

    @Override
    public void updateAccount(Account account) {

    }
}
