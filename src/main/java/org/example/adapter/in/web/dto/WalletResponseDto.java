package org.example.adapter.in.web.dto;

import java.math.BigDecimal;
import java.util.UUID;


public class WalletResponseDto {
    private final UUID walletId;
    private final BigDecimal balance;

    public WalletResponseDto(UUID walletId, BigDecimal balance) {
        this.walletId = walletId;
        this.balance = balance;
    }

    public UUID getWalletId() {
        return walletId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

}

