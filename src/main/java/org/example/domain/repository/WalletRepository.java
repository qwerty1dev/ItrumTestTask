package org.example.domain.repository;

import org.example.domain.entity.Wallet;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository {
    Optional<Wallet> findById(UUID walletId);
    Wallet save(Wallet wallet);
}
