package account.dto;

import account.domain.Account;

public class AccountCreateRequest {
    private String email;
    private String lastName;
    private String firstName;

    public Account toAccount() {
        return Account.builder()
                .email(this.email)
                .lastName(this.lastName)
                .firstName(this.firstName)
                .build();
    }
}
