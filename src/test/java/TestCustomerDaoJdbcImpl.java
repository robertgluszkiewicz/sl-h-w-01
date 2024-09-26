import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.sql.SQLException;

import org.testng.annotations.Test;

import homework.bank.dao.CustomerDaoJdbcImpl;
import homework.bank.model.Customer;

public class TestCustomerDaoJdbcImpl {
    @Test
    void testJdbcCrudOperations() throws SQLException {
        CustomerDaoJdbcImpl customerDaoJdbcImpl = new CustomerDaoJdbcImpl();
        Customer testCustomer = new Customer(
                3,
                "TestFirstName",
                "TestLastName",
                "TestPhone",
                "TestEmail");


        //INSERT test
        assertTrue(customerDaoJdbcImpl.insert(testCustomer));

        //SELECT test
        int customerId = 51;
        assertNotNull(customerDaoJdbcImpl.getEntityById(customerId));

        //UPDATE test
        testCustomer.setFirstName("UpdatedTestFirstName");
        customerDaoJdbcImpl.update(testCustomer, customerId);

        //DELETE test
        assertTrue(customerDaoJdbcImpl.delete(customerId));
        assertNull(customerDaoJdbcImpl.getEntityById(customerId));
    }
}
