package ua.bondary.bankapp.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBOConverter<T> {
    public T createFromDB(ResultSet rs) throws SQLException;
}
