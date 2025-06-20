package org.example.adapter.out.jpa;

import org.example.domain.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface JpaWalletRepository extends JpaRepository<Wallet, UUID> {}
