package ua.bondary.bankapp.finance.service;

import com.sun.istack.internal.NotNull;
import ua.bondary.bankapp.finance.domain.Account;
//import ua.bondary.bankapp.repo.AccountRepo;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class AccountService {
   // private AccountRepo repo;


//    public AccountService(AccountRepo repo) {
//        this.repo = repo;
//    }

    public AccountService() {

    }

    public double getBalance() {
        return 0;
    }

    public Collection<Account> all() {

        return new ArrayList<Account>();
    }

    public void save(@NotNull Long id, Double balance) {
//        if (this.repo == null)
//            System.out.println("repo is null!!");
//        else
//        this.repo.update(new Account(id,balance));
    }

    public Account findByPhone(String phone) {
//        Optional<Account> account =repo.findById(1L);
//        return account.get();
        return null;
    }

    public Account findById(Long id) {
//        if (this.repo == null)
//            System.out.println("repo is null!!");
//        else {
//            Optional<Account> account = repo.findById(id);
//            return account.get();
//        }
        return null;
    }

}
