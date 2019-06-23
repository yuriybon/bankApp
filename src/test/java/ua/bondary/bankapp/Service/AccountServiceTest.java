package ua.bondary.bankapp.Service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountServiceTest {

    @Test
    public void getBalanceTest() {
        AccountService accountService = new AccountService();

        assertThat(accountService.getBalance(), is(0.0));
    }
}
