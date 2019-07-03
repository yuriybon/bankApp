package ua.bondary.bankapp.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import ua.bondary.bankapp.JettyServer4Test;
import ua.bondary.bankapp.finance.domain.Bank;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static javax.ws.rs.client.Entity.json;

public class BankControllerTest extends JettyServer4Test {

    private WebTarget bankController;

//    public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz)
//            throws IOException {
//
//        String jsonFromResponse = EntityUtils.toString(response.getEntity());
//        ObjectMapper mapper = new ObjectMapper()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        return mapper.readValue(jsonFromResponse, clazz);
//    }

    @Before
    public void setUp() {

      //  bankController = resource("bank");

    }

    @Test
    public void getBank() throws IOException {
        //Bank b = bankController.request().get(Bank.class);
        bankController = resource("bank/getById");
        //accountController.path("777-777-777-777").request().

        String b =  bankController.path("1").request().get().readEntity(String.class);
        System.out.println(b);
        ObjectMapper mapper = new ObjectMapper();

        Bank bank = mapper.readValue(b,Bank.class);
//
//        //.toString(); readEntity(Bank.class);
        System.out.println(bank.getName());
////        String data = yourdata;
//        JSONObject jsonData = new JSONObject(data);
//        JSONOBject jsonResult = new JSONObject(jsonData.getString("Result"));
//        JSONOBject jsonResponse = new JSONObject(jsonData.getString("Response"));
//        String status = jsonResult.getString("Status");
        //String data = bankController.path("1").request().get().;

        //System.out.println( b.getStatus());

        //assertTrue(b.getName().equals("MyBank"));
    }
}
