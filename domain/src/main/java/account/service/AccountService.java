package account.service;

import account.domain.Account;
import account.domain.AccountId;
import account.dto.AccountCreateRequest;
import account.exception.AccountException;
import account.repository.AccountRepository;

import java.util.List;

public class AccountService {
    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(AccountCreateRequest accountCreateRequest) {
        Account account = accountRepository.save(accountCreateRequest.toAccount());
        return account;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(AccountId accountId) {
        Account account = accountRepository.findByAccountId(accountId)
                .orElseThrow(() -> new AccountException("not found Account"));

        return account;
    }

}
