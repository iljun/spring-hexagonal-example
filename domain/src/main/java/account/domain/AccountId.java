package account.domain;

import java.util.Comparator;

public abstract class AccountId<T> implements Comparable {

    public abstract void setId(T id);

    public abstract T getId();
}
