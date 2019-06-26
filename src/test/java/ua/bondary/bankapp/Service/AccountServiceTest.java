package ua.bondary.bankapp.service;

import org.junit.Test;
import ua.bondary.bankapp.domain.Account;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountServiceTest {

    @Test
    public void getBalanceTest() {
        AccountService accountService = new AccountService();
        //Account acc = accountService.findByPhone("");
        Account acc = accountService.findById((long) 1);
        if (acc == null )
            accountService.save((long)1,(double) 10);
        acc = accountService.findById((long) 1);
        assertThat(acc.getBalance(), is(10.0));

    }
}
