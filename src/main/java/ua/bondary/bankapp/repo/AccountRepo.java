package ua.bondary.bankapp.repo;

import ua.bondary.bankapp.domain.Account;

import javax.validation.constraints.NotNull;
import java.util.Optional;


public interface AccountRepo {
    Optional<Account> findById(@NotNull Long id);

    Optional<Account> save(Double balance);

    void deleteById(@NotNull Long id);

    int update(Account account);
}
