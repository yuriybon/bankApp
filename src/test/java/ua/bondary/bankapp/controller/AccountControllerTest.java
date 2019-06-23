package ua.bondary.bankapp.controller;

import org.junit.Before;
import org.junit.Test;
import ua.bondary.bankapp.HttpServer4Test;
import ua.bondary.bankapp.domain.Account;

import javax.ws.rs.client.WebTarget;

import static javax.ws.rs.client.Entity.json;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class AccountControllerTest extends HttpServer4Test {

    private WebTarget accountController;

    private static final Account BOB_ACCOUNT = new Account();

    @Before
    public void setUp() {

        accountController = resource("account");

    }

    @Test
    public void getByPhoneTest() {
        accountController.request().put(json(BOB_ACCOUNT));

        Account testAccount = accountController.path("777-777-777-777").request().get(Account.class);

        assertThat(testAccount.getBalance(), is(10.0));
    }

}
