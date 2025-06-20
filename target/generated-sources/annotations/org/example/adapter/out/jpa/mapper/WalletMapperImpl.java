package org.example.adapter.out.jpa.mapper;

import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.example.adapter.out.jpa.entity.WalletEntity;
import org.example.domain.entity.Wallet;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-20T16:35:42+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class WalletMapperImpl implements WalletMapper {

    @Override
    public WalletEntity toEntity(Wallet wallet) {
        if ( wallet == null ) {
            return null;
        }

        UUID id = null;
        BigDecimal balance = null;

        id = wallet.getId();
        balance = wallet.getBalance();

        Long version = null;

        WalletEntity walletEntity = new WalletEntity( id, balance, version );

        return walletEntity;
    }

    @Override
    public Wallet toDomain(WalletEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        BigDecimal balance = null;

        id = entity.getId();
        balance = entity.getBalance();

        Wallet wallet = new Wallet( id, balance );

        return wallet;
    }
}
