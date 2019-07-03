package ua.bondary.bankapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.bondary.bankapp.finance.dao.Sql2oBankDao;
import ua.bondary.bankapp.finance.domain.Bank;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.SQLException;


import static javax.ws.rs.core.Response.noContent;

@Path("bank")
//@Consumes("application/json;charset=utf-8")
//@Produces("application/json;charset=utf-8")
public class BankController {

//    @GET
//    @Path("{bankId}")
//    public Response getById(@PathParam("bankId") String bankId) {
//        System.out.println("bankId"+bankId);
//        try {
//            Bank b = new Sql2oBankDao().getBankById(1);
//           // return ok(b).build();
//            return Response.status(200).entity(b.toString()).build();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return noContent().build();
//    }

    @GET
    @Path("{bankId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("bankId") String bankId) {
        System.out.println("bankId"+bankId);
        try {
            Bank b = new Sql2oBankDao().getBankById(1);
            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(b);
                return Response.ok().entity(b).build();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            // return ok(b).build();
            return Response.noContent().build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
