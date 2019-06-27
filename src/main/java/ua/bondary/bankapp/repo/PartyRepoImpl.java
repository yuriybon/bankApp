package ua.bondary.bankapp.repo;

import ua.bondary.bankapp.domain.Account;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Optional;

public class PartyRepoImpl implements PartyRepo {

    @Inject
    private DataSource dataSource;

    @Override
    public Optional<Account> findById(Long id) {
        return null;
    }

    @Override
    public Optional<Account> save(Double balance) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public int update(Account account) {
        return 0;
    }
}
