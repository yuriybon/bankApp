package ua.bondary.bankapp.dbutils;

import org.junit.Assert;
import org.junit.Test;

import javax.sql.DataSource;
import javax.validation.constraints.AssertTrue;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertThat;

public class DevelopmentDatasourceFactoryTest {

    @Test
    public void makeTest() {
        DataSource ds =  new DevelopmentDatasourceFactory().make();
        assertFalse(ds == null);
    }
}
