package ua.bondary.bankapp;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.After;
import org.junit.Before;

import javax.ws.rs.client.WebTarget;

import static javax.ws.rs.client.ClientBuilder.newClient;

public abstract class HttpServer4Test {

    private HttpServer server;

    @Before
    public void startServer() throws Exception {
        server = ServerApp.startServer(new BankAppBinder(), "8087");
    }

    @After
    public void stopServer() throws Exception {
        server.shutdownNow();
    }

    protected WebTarget resource(String path) {
        javax.ws.rs.client.Client client = newClient();
        client.register(JacksonFeature.class);
        return client.target("http://localhost:8087/api/").path(path);
    }
}
