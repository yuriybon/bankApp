package ua.bondary.bankapp.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    static volatile Connection conn;

    //set here a static c'tor to handle the connection to the database

    //The General generic method:
    public static <T> List<T> GetObjectsFromDB(String sqlQuery, DBOConverter dbo)
    {
        List<T> ResList = new ArrayList<>();

        try
        {
            Statement st = conn.createStatement();
            for (ResultSet rs = st.executeQuery(sqlQuery); rs.next();)
            {
                ResList.add((T) dbo.createFromDB(rs));
            }
        }
        catch (SQLException ex)
        {
            //_LOG_ERROR(ex.getMessage());
            System.out.println(ex.getMessage());
        }

        return ResList;
    }

}
