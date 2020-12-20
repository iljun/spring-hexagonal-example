package com.iljun.hexagonal.adapter.rest.api;

import account.InMemoryAccountId;
import account.domain.Account;
import account.dto.AccountCreateRequest;
import account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class AccountApi {
    private final AccountService accountService;
    public AccountApi(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/api/accounts")
    public ResponseEntity getAllAccounts() {
        List<Account> accounts = this.accountService.findAll();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/api/account/{id}")
    public ResponseEntity getAccount(@PathVariable("id") long id) {
        Account account = this.accountService.findById(new InMemoryAccountId(id));
        return ResponseEntity.ok(account);
    }

    @PostMapping("/api/account")
    public ResponseEntity saveAccount(@RequestBody AccountCreateRequest accountCreateRequest) {
        Account account = this.accountService.createAccount(accountCreateRequest);
        return ResponseEntity.created(URI.create("TODO location")).build();
    }
}
