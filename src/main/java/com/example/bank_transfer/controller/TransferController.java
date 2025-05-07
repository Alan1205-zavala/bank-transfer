package com.example.bank_transfer.controller;

import com.example.bank_transfer.dto.TransferRequest;
import com.example.bank_transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Añadir prefijo de ruta
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSourceAccountId(),
                request.getTargetAccountId(),
                request.getAmount()
        );
        return ResponseEntity.ok("Transfer completed successfully");
    }
} 
