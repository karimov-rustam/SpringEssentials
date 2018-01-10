package edu.spring.entities;

import org.hibernate.annotations.Entity;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Account {
    @Id
    private Long id;
    private BigDecimal balance;

    public Account(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, balance);
    }

    @Override
    public String toString() {
        return String.format("Account{id=%d, balance=%s}", id, balance);
    }
}
