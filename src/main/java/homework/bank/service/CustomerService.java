package homework.bank.service;

import java.sql.SQLException;
import java.util.Collection;

import homework.bank.dao.CustomerDaoJdbcImpl;
import homework.bank.model.Customer;

public class CustomerService implements Service<Customer, Integer> {
    private CustomerDaoJdbcImpl customerDaoJdbcImpl;

    public CustomerService(CustomerDaoJdbcImpl customerDaoJdbcImpl) {
        this.customerDaoJdbcImpl = customerDaoJdbcImpl;
    }

    @Override
    public Collection<Customer> getAll() throws SQLException {
        return customerDaoJdbcImpl.getAll();
    }

    @Override
    public Customer getById(Integer customerId) throws SQLException {
        Customer customer = customerDaoJdbcImpl.getEntityById(customerId);
        if (customer == null) {
            System.out.println("Customer ID = " + customerId + " not found");
        } else {
            System.out.println("Customer ID = " + customerId + " found: " + customer.getFirstName() + " " + customer.getLastName());
        }
        return customer;
    }

    @Override
    public boolean save(Customer customer) {
        return customerDaoJdbcImpl.insert(customer);
    }

    @Override
    public void update(Customer newCustomer, Integer id) {
        customerDaoJdbcImpl.update(newCustomer, id);
    }

    @Override
    public boolean delete(Integer id) {
        return customerDaoJdbcImpl.delete(id);
    }
}
