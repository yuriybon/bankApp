package ua.bondary.bankapp.controller;

import ua.bondary.bankapp.domain.Account;
import ua.bondary.bankapp.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;

@Path("account")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class AccountController {

    private final AccountService accountService;


    @Inject
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GET
    @Path("{phone}")
    public Response getByPhone(@PathParam("phone") String phone) {
        System.out.println("phone="+phone);
        Account account = accountService.findByPhone(phone);
        return ok(account).build();
    }

    @GET
    public Response getAll() {
        return ok(serializeCollection(accountService.all())).build();
    }

    @PUT
    public Response save(Account account) {
        accountService.save(account);
        return noContent().build();
    }

    private GenericEntity<Collection<Account>> serializeCollection(final Collection<Account> collection) {
        return new GenericEntity<Collection<Account>>(collection) {};
    }
}

