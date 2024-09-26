import java.sql.SQLException;

import org.testng.annotations.Test;

import homework.bank.dao.CustomerDaoJdbcImpl;
import homework.bank.service.CustomerService;

public class TestCustomerService {
    @Test
    void testCustomerService() throws SQLException {
        CustomerDaoJdbcImpl cd = new CustomerDaoJdbcImpl();
        CustomerService cs = new CustomerService(cd);
        cs.getById(6);
    }
}
