package ua.bondary.bankapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HttpAPIServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Servlet service method invoked");
        resp.getOutputStream().println("Servlet service method invoked");

//        List<String> articleNames = DatabaseUtil.getArticleNames();
//        for (String articleName : articleNames) {
//            resp.getOutputStream().println(articleName);
//        }
    }
}
