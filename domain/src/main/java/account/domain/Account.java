package account.domain;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
    @Getter
    @Setter
    private AccountId id;
    private String email;
    private String lastName;
    private String firstName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public Account(String email,
                   String lastName,
                   String firstName) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
