package org.example.usecase.interactor;

import org.example.domain.OperationType;
import org.example.domain.entity.Wallet;
import org.example.domain.repository.WalletRepository;
import org.example.usecase.port.in.WalletService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;


@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final ConcurrentMap<UUID, ReentrantLock> locks = new ConcurrentHashMap<>();

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    @Override
    public void operate(UUID walletId, OperationType opType, BigDecimal amount) {
        ReentrantLock lock = locks.computeIfAbsent(walletId, id -> new ReentrantLock());
        lock.lock();
        try {
            Wallet wallet;
            if (opType == OperationType.DEPOSIT) {
                wallet = walletRepository.findById(walletId)
                        .orElse(new Wallet(walletId, BigDecimal.ZERO));
                wallet.deposit(amount);
            } else {
                wallet = walletRepository.findById(walletId)
                        .orElseThrow(() -> new IllegalArgumentException("Wallet not found: " + walletId));
                wallet.withdraw(amount);
            }
            walletRepository.save(wallet);
        } finally {
            lock.unlock();
        }
    }


    @Override
    public BigDecimal getBalance(UUID walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found: " + walletId))
                .getBalance();
    }
}