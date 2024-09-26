package homework.bank.service;

import java.sql.SQLException;
import java.util.Collection;

import homework.bank.dao.CustomerDaoMyBatisImpl;
import homework.bank.model.Customer;

public class CustomerServiceMyBatis implements Service<Customer, Integer> {
    private CustomerDaoMyBatisImpl customerDaoMyBatis;

    public CustomerServiceMyBatis(CustomerDaoMyBatisImpl customerDaoMyBatis) {
        this.customerDaoMyBatis = customerDaoMyBatis;
    }

    @Override
    public Collection<Customer> getAll() throws SQLException {
        return customerDaoMyBatis.getAll();
    }

    @Override
    public Customer getById(Integer customerId) throws SQLException {
        Customer customer = customerDaoMyBatis.getEntityById(customerId);
        if (customer == null) {
            System.out.println("Customer ID = " + customerId + " not found");
        } else {
            System.out.println("Customer ID = " + customerId + " found: " + customer.getFirstName() + " " + customer.getLastName());
        }
        return customer;
    }

    @Override
    public boolean save(Customer customer) throws SQLException {
        return customerDaoMyBatis.insert(customer);
    }

    @Override
    public void update(Customer newCustomer, Integer id) throws SQLException {
        customerDaoMyBatis.update(newCustomer, id);
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return customerDaoMyBatis.delete(id);
    }
}
