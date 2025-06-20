package org.example.domain.entity;


import jakarta.persistence.*;
import org.example.domain.exception.InsufficientFundsException;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    private UUID id;

    @Column(nullable = false)
    private BigDecimal balance;

    @Version
    private Long version;

    protected Wallet() {
    }

    public Wallet(UUID id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Not enough money");
        }
        balance = balance.subtract(amount);
    }
    
}
