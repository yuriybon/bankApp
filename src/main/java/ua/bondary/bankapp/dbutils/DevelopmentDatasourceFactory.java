package ua.bondary.bankapp.dbutils;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DevelopmentDatasourceFactory {

    public DataSource make() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        //ds.setUrl("jdbc:h2:file:~/myh2db;DB_CLOSE_ON_EXIT=FALSE;INIT=RUNSCRIPT FROM 'classpath:sql/create.sql'\\;RUNSCRIPT FROM 'classpath:sql/data.sql'");
        ds.setUrl("jdbc:h2:file:~/myh2db;DB_CLOSE_ON_EXIT=FALSE;");
        ds.setUsername("sa");
        ds.setPassword("");
         return ds;
    }

}
