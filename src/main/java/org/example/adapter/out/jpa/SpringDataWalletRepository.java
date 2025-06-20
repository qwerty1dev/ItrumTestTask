package org.example.adapter.out.jpa;


import org.example.domain.entity.Wallet;
import org.example.domain.repository.WalletRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public class SpringDataWalletRepository implements WalletRepository {
    private final JpaWalletRepository jpaRepository;

    public SpringDataWalletRepository(JpaWalletRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Wallet> findById(UUID walletId) {
        return jpaRepository.findById(walletId);
    }

    @Override
    public Wallet save(Wallet wallet) {
        return jpaRepository.save(wallet);
    }
}