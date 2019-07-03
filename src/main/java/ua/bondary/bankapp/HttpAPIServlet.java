package ua.bondary.bankapp;

import ua.bondary.bankapp.dbutils.DataBaseAPI;
import ua.bondary.bankapp.finance.dao.Sql2oBankDao;
import ua.bondary.bankapp.finance.domain.Bank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HttpAPIServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Servlet service method invoked");

       // resp.getOutputStream().println("Servlet service method invoked");

//            List<String> articleNames = DataBaseAPI.getBankNames();
//            for (String articleName : articleNames) {
//                resp.getOutputStream().println(articleName);
//            }
        try {
            Bank b = new Sql2oBankDao().getBankById(1);
            resp.getOutputStream().println(b.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        List<String> articleNames = DatabaseUtil.getArticleNames();
//        for (String articleName : articleNames) {
//            resp.getOutputStream().println(articleName);
//        }
    }
}
