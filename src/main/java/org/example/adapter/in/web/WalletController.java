package org.example.adapter.in.web;


import jakarta.validation.Valid;
import org.example.adapter.in.web.dto.WalletRequestDto;
import org.example.adapter.in.web.dto.WalletResponseDto;
import org.example.usecase.port.in.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }
    
    @PostMapping("/wallet")
    public ResponseEntity<Void> operate(@RequestBody @Valid WalletRequestDto req) {
        walletService.operate(req.getWalletId(), req.getOperationType(), req.getAmount());
        URI location = URI.create("/api/v1/wallets/" + req.getWalletId());
        return ResponseEntity.created(location).build();
    }
    
    @GetMapping("/wallets/{id}")
    public ResponseEntity<WalletResponseDto> getBalance(@PathVariable UUID id) {
        var balance = walletService.getBalance(id);
        return ResponseEntity.ok(new WalletResponseDto(id, balance));
    }
}
