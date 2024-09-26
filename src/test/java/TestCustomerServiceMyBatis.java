import java.sql.SQLException;

import org.testng.annotations.Test;

import homework.bank.dao.CustomerDaoMyBatisImpl;
import homework.bank.service.CustomerServiceMyBatis;

public class TestCustomerServiceMyBatis {
    @Test
    void testCustomerServiceMyBatis() throws SQLException {
        CustomerDaoMyBatisImpl cd = new CustomerDaoMyBatisImpl();
        CustomerServiceMyBatis cs = new CustomerServiceMyBatis(cd);
        cs.getById(7);
    }
}
