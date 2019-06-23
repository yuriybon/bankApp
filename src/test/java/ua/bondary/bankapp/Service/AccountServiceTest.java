package ua.bondary.bankapp.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountServiceTest {

    @Test
    public void getBalanceTest() {
        AccountService accountService = new AccountService();

        assertThat(accountService.findByPhone("").getBalance(), is(10.0));
    }
}
