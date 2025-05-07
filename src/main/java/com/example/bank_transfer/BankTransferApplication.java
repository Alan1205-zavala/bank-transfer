package com.example.bank_transfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.bank_transfer", "com.example.bank_transfer.controller"})
public class BankTransferApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankTransferApplication.class, args);
	}
}
