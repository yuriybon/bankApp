package ua.bondary.bankapp.finance.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ua.bondary.bankapp.dbutils.DataBaseAPI;
import ua.bondary.bankapp.finance.domain.Bank;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;



public class Sql2oBankDao implements BankDao {
    @Override
    public void add(Bank bank) {
    }

    @Override
    public List<Bank> getAll() {
        return null;
    }

    @Override
    public Bank getBankById(int bankId) throws SQLException {
        DbUtils.loadDriver("org.h2.Driver");
        DataSource ds = DataBaseAPI.getDataSource();
        QueryRunner run = new QueryRunner(ds);

// Use the BeanListHandler implementation to convert all
// ResultSet rows into a List of Person JavaBeans.
        ResultSetHandler<List<Bank>> h = new BeanListHandler<Bank>(Bank.class);

// Execute the SQL statement and return the results in a List of
// Person objects generated by the BeanListHandler.
        List<Bank> banks = run.query(DataBaseAPI.getDataSource().getConnection(),"SELECT * FROM BANK", h);
        return banks.get(0);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
