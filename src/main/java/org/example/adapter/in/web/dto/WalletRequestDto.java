package org.example.adapter.in.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.example.domain.OperationType;

import java.math.BigDecimal;
import java.util.UUID;


public class WalletRequestDto {
    @NotNull
    private UUID walletId;
    @NotNull
    private OperationType operationType;
    @NotNull
    @Min(0)
    private BigDecimal amount;
    
    public @NotNull UUID getWalletId() {
        return walletId;
    }

    public @NotNull OperationType getOperationType() {
        return operationType;
    }

    public @NotNull @Min(0) BigDecimal getAmount() {
        return amount;
    }

}
