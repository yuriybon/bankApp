package ua.bondary.bankapp.repo;

import ua.bondary.bankapp.domain.Account;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AccountRepoImpl implements AccountRepo {
    private DataSource dataSource;
    private Long localID = 0L;

    @Inject
    public AccountRepoImpl(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Account> findById(Long id) {
        try {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();

                String sql = "select * FROM ACCOUNT WHERE id=?";
                PreparedStatement statement = null;
                try {
                    statement = connection.prepareStatement(sql);
                    statement.setLong(1, id);
                    ResultSet rs = null;
                    try {
                        rs = statement.executeQuery();
                        while (rs.next()) {
                            return buildAccount(rs);
                        }
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (statement != null) {
                        statement.close();
                    }
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Optional<Account> buildAccount(ResultSet rs) throws SQLException {
        return Optional.of(new Account(rs.getLong("id"), rs.getDouble("balance")));

    }

    private Long getId() {
        return localID+1;
    }

    @Override
    public Optional<Account> save(Double balance) {
        try {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();

                String sql = "INSERT INTO ACCOUNT (ID,BALANCE) VALUES (?,?)";
                PreparedStatement statement = null;
                try {
                    statement = connection.prepareStatement(sql);
                    Long accountId = getId();
                    statement.setDouble(1, accountId);
                    statement.setDouble(2, balance);
                        statement.execute();
                        return findById(accountId);
                } finally {
                    if (statement != null) {
                        statement.close();
                    }
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public int update(Account account) {
        try {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();

                String sql = "UPDATE ACCOUNT SET BALANCE=? WHERE ID = ?";
                PreparedStatement statement = null;
                try {
                    statement = connection.prepareStatement(sql);
                    Long accountId = getId();
                    statement.setDouble(1, account.getBalance());
                    statement.setLong(2, account.getId());

                    statement.execute();
                    return 1;
                } finally {
                    if (statement != null) {
                        statement.close();
                    }
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
