package ua.bondary.bankapp.dbutils;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseAPI {

//    public static void main(String[] args) {
//
//        List<String> articleNames = getArticleNames();
//
//        System.out.println(articleNames);
//
//    }

    private static Connection createConnection() {
        try {
            InitialContext ctx = new InitialContext();
            // Here we lookup the datasource with the name
            // "java:comp/env/jdbc/jcgDS"
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jcgDS");
            return ds.getConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
    }

    public static List<String> getBankNames() {

        Connection conn = createConnection();
        List<String> articleNames = new ArrayList<String>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from BANK");
            while (rs.next()) {
                String articleName = rs.getString("NAME");
                if (articleName != null) {
                    articleNames.add(articleName);
                }
            }
            conn.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return articleNames;
    }

}
