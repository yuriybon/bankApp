package ua.bondary.bankapp.controller;

import org.junit.Before;
import org.junit.Test;
import ua.bondary.bankapp.JettyServer4Test;
import ua.bondary.bankapp.finance.domain.Bank;

import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertTrue;

public class BankControllerTest extends JettyServer4Test {

    private WebTarget bankController;

    @Before
    public void setUp() {

        bankController = resource("");

    }

    @Test
    public void getBank() {
        Bank b = bankController.request().get(Bank.class);

        assertTrue(b.getName().equals("MyBank"));
    }
}
