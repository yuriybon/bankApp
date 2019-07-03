package ua.bondary.bankapp;

import org.glassfish.hk2.api.Factory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import ua.bondary.bankapp.finance.domain.Bank;

public class BankAppConfig extends ResourceConfig {

    public BankAppConfig()  {
        packages("ua.bondary.bankapp");
        register(Bank.class);
        register(JacksonFeature.class);

//        try {
//            registerInstances(
//                    new AccountController(new AccountService(new AccountRepoImpl(lookupDatasource())))
//            );
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

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


}
