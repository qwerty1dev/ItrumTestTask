package org.example.adapter.out.jpa.mapper;

import org.example.adapter.out.jpa.entity.WalletEntity;
import org.example.domain.entity.Wallet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {
    WalletEntity toEntity(Wallet wallet);
    Wallet toDomain(WalletEntity entity);
}