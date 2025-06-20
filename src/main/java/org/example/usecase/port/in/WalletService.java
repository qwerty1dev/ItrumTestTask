package org.example.usecase.port.in;

import org.example.domain.OperationType;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletService {
    void operate(UUID walletId, OperationType opType, BigDecimal amount);
    BigDecimal getBalance(UUID walletId);
}
