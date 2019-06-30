package ua.bondary.bankapp.dbutils;


import org.junit.Test;
import ua.bondary.bankapp.JettyServer4Test;

import javax.ws.rs.client.WebTarget;
import java.util.List;

public class DBManagerTest extends JettyServer4Test {

    @Test
    public void getBankNamesTest() {
       List<String> banks =  DataBaseAPI.getBankNames();
       for (String bank:banks) {
           System.out.println(bank);
       }
    }
}
