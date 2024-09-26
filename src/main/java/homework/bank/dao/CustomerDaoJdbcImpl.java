package homework.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import homework.bank.connection.CustomConnection;
import homework.bank.exception.DbCRUDException;
import homework.bank.model.Customer;

public class CustomerDaoJdbcImpl implements Dao <Customer, Integer> {
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM bank.customer";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM bank.customer WHERE customer_id = ?";
    private static final String INSERT_CUSTOMER = "INSERT INTO bank.customer (address_id, first_name, last_name, phone, email) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER = "UPDATE bank.customer SET address_id = ?, first_name = ?, last_name = ?, phone = ?, email = ? WHERE customer_id = ?";
    private static final String DELETE_CUSTOMER = "DELETE FROM bank.customer WHERE customer_id = ?";
    @Override
    public List getAll() {
        try (Connection connection = CustomConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
             ResultSet rs = ps.executeQuery()) {
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) {
                customers.add(mapResultSetToCustomer(rs));
            }
            return customers;
        } catch (SQLException e) {
            throw new DbCRUDException("CustomerDao.getAll() error occurred", e);
        }
    }

    @Override
    public Customer getEntityById(Integer id) {
        try (Connection connection = CustomConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
             ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapResultSetToCustomer(rs) : null;
            }
        } catch (SQLException e) {
            throw new DbCRUDException("CustomerDao.getEntityById() error occurred", e);
        }
    }

    @Override
    public boolean insert(Customer customer) {
        try (Connection connection = CustomConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER)) {
            setCustomerParameters(ps, customer);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DbCRUDException("CustomerDao.insert() error occurred", e);
        }

    }

    @Override
    public void update(Customer customer, Integer id) {
        try (Connection connection = CustomConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER)) {
            setCustomerParameters(ps, customer, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbCRUDException("CustomerDao.update() error occurred", e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (Connection connection = CustomConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DbCRUDException("CustomerDao.delete() error occurred", e);
        }
    }

    private Customer mapResultSetToCustomer(ResultSet rs) throws SQLException {
        return new Customer(
                rs.getInt("address_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("phone"),
                rs.getString("email")
        );
    }

    private void setCustomerParameters(PreparedStatement ps, Customer customer, Integer... id) throws SQLException {
        ps.setInt(1, customer.getAddressId());
        ps.setString(2, customer.getFirstName());
        ps.setString(3, customer.getLastName());
        ps.setString(4, customer.getPhone());
        ps.setString(5, customer.getEmail());
        if (id.length > 0) {
            ps.setInt(6, id[0]);
        }
    }
}
