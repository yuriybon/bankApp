package ua.bondary.bankapp;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import ua.bondary.bankapp.controller.BankController;
import ua.bondary.bankapp.controller.MyResource;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(BankController.class);
        return set;
    }
}

