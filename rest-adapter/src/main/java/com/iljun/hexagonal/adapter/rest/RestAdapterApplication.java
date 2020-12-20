package com.iljun.hexagonal.adapter.rest;

import account.AccountImMemoryRepository;
import account.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestAdapterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestAdapterApplication.class, args);
    }

    @Bean
    public AccountService accountService() {
        return new AccountService(new AccountImMemoryRepository());
    }
}
