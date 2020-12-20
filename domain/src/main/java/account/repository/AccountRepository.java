package account.repository;

import account.domain.Account;
import account.domain.AccountId;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);

    Optional<Account> findByAccountId(AccountId accountId);

    List<Account> findAll();

}
