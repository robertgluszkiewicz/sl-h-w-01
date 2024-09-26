import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.sql.SQLException;

import org.testng.annotations.Test;

import homework.bank.dao.CustomerDaoMyBatisImpl;
import homework.bank.model.Customer;

public class TestCustomerDaoMyBatisImpl {
    @Test
    void testMyBatisCRUDOperations() throws SQLException {
        CustomerDaoMyBatisImpl cdmb = new CustomerDaoMyBatisImpl();
        Customer testCustomer = new Customer(
                3,
                "TestFirstName",
                "TestLastName",
                "TestPhone",
                "TestEmail");

        //INSERT test
        assertTrue(cdmb.insert(testCustomer));

        //SELECT test
        int customerId = 54;
        assertNotNull(cdmb.getEntityById(customerId));

        //UPDATE test
        testCustomer.setFirstName("UpdatedTestFirstName");
        //testCustomer.setAddressId(1);
        cdmb.update(testCustomer, customerId);

        //DELETE test
        assertTrue(cdmb.delete(customerId));
        assertNull(cdmb.getEntityById(customerId));
    }
}
