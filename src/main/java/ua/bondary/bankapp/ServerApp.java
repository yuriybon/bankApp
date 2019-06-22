package ua.bondary.bankapp;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import static org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory.createHttpServer;

public class ServerApp {



    public static HttpServer startServer() throws MalformedURLException {
        HttpServer httpServer = createHttpServer(URI.create("http://localhost:8081/api/"), new BankAppConfig());
        addStaticContent(httpServer);
        return httpServer;
    }

    public static HttpServer startServer(AbstractBinder binder, String port) {
        ResourceConfig config = new ResourceConfig();
        config.packages("ua.bondary.bankapp");
        config.register(binder);
        HttpServer httpServer = createHttpServer(URI.create("http://localhost:" + port + "/api/"), config);
        addStaticContent(httpServer);
        return httpServer;
    }

    public static HttpServer startServer(AbstractBinder binder) {
        return startServer(binder, "8081");
    }

    private static void addStaticContent(HttpServer httpServer) {
        httpServer.getServerConfiguration().addHttpHandler(new StaticHttpHandler("src/main/webapp/"));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("MyServer");
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", "http://localhost:8081/api/"));
        System.in.read();
        server.stop();
    }
}
