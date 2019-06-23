package ua.bondary.bankapp;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import ua.bondary.bankapp.controller.AccountController;
import ua.bondary.bankapp.service.AccountService;

import javax.inject.Singleton;

public class BankAppBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(AccountService.class).to(AccountService.class);
        bind(AccountController.class).to(AccountController.class);
    }
}
