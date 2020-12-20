package account;

import account.domain.Account;
import account.domain.AccountId;
import account.repository.AccountRepository;

import java.util.*;

public class AccountImMemoryRepository implements AccountRepository {
    private Map<AccountId, Account> inMemoryAccounts;
    private final InMemoryAccountId defaultAccountId;
    public AccountImMemoryRepository() {
        this.inMemoryAccounts = new HashMap<>();
        this.defaultAccountId = new InMemoryAccountId();
        this.defaultAccountId.setId(0L);
    }

    @Override
    public Account save(Account account) {
        Set<AccountId> keySets = inMemoryAccounts.keySet();
        InMemoryAccountId accountId = (InMemoryAccountId) keySets.stream()
                                    .sorted(Comparator.reverseOrder())
                                    .findFirst()
                                    .orElse(this.defaultAccountId);
        accountId.setId(accountId.getId() + 1);
        inMemoryAccounts.put(accountId, account);
        return account;
    }

    @Override
    public Optional<Account> findByAccountId(AccountId accountId) {
        return Optional.ofNullable(inMemoryAccounts.get(accountId));
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(inMemoryAccounts.values());
    }
}
