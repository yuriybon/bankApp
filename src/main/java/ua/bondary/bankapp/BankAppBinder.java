package ua.bondary.bankapp;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import ua.bondary.bankapp.controller.AccountController;
import ua.bondary.bankapp.repo.AccountRepo;
import ua.bondary.bankapp.repo.AccountRepoImpl;
import ua.bondary.bankapp.service.AccountService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public class BankAppBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(AccountService.class).to(AccountService.class);
        bind(AccountController.class).to(AccountController.class);
        bind(AccountRepoImpl.class).to(AccountRepo.class);
        bind(DataSource.class).to(DataSource.class).in(Singleton.class);
        bindFactory(EMFactory.class).to(EntityManagerFactory.class).in(Singleton.class);
        bindFactory(EMFactory.class).to(EntityManager.class).in(RequestScoped.class);

    }
}
