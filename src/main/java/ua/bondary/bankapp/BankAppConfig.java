package ua.bondary.bankapp;

import org.glassfish.hk2.api.Factory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import ua.bondary.bankapp.controller.AccountController;
import ua.bondary.bankapp.dbutils.DevelopmentDatasourceFactory;
import ua.bondary.bankapp.repo.AccountRepoImpl;
import ua.bondary.bankapp.service.AccountService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;


public class BankAppConfig extends ResourceConfig {

    public BankAppConfig()  {
        packages("ua.bondary.bankapp");
        register(new BankAppBinder());
        register(lookupDatasource());
        register(JacksonFeature.class);

        try {
            registerInstances(
                    new AccountController(new AccountService(new AccountRepoImpl(lookupDatasource())))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static <T> Factory<T> factory(T instance) {
        return new Factory<T>() {
            @Override
            public T provide() {
                return instance;
            }

            @Override
            public void dispose(T instance) {}
        };
    }

    private DataSource lookupDatasource() {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        try {
            return (DataSource) ctx.lookup("jdbc/bankunitDB");
        } catch (NamingException e) {
            //throw new RuntimeException("Could not find jdbc/bankunitDB Datasource in JNDI context. Bailing!", e);
           return new DevelopmentDatasourceFactory().make();
        } catch (ClassCastException e){
            //throw new RuntimeException("Expected jdbc/bankunitDB JNDI resource to be a DataSource, but it wasn't! Bailing!", e);
           return new DevelopmentDatasourceFactory().make();
        }
    }

}
