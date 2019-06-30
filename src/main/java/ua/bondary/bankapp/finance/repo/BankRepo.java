package ua.bondary.bankapp.finance.repo;

import ua.bondary.bankapp.dbutils.DBManager;
import ua.bondary.bankapp.finance.domain.Bank;

import java.sql.SQLException;
import java.util.List;

public class BankRepo {

    public static List<Bank> getAll() throws SQLException
    {
        String Query = "select * "
                + "from BANK";

        return DBManager.GetObjectsFromDB(Query, rs -> new Bank(rs));
    }


}
