package account;

import account.domain.AccountId;

public class InMemoryAccountId extends AccountId<Long> {
    private long id;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        long id = (Long) obj;
        if (id == 0 ) {
            return false;
        }

        return this.id == id;
    }

    @Override
    public int compareTo(Object o) {
        InMemoryAccountId a = (InMemoryAccountId) o;
        return (int) (a.getId() - this.id);
    }
}
