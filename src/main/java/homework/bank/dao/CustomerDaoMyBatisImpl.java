package homework.bank.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import homework.bank.model.Customer;

public class CustomerDaoMyBatisImpl implements Dao<Customer, Integer> {
    @Override
    public List<Customer> getAll() throws SQLException {
        try (SqlSession session = DaoMyBatisConfig.getSessionFactory().openSession(true)) {
            return session.selectList("homework.bank.dao.Dao.getAll");
        }
    }

    @Override
    public Customer getEntityById(Integer id) throws SQLException {
        try (SqlSession session = DaoMyBatisConfig.getSessionFactory().openSession(true)) {
            return session.selectOne("homework.bank.dao.Dao.getEntityById", id);
        }
    }

    @Override
    public boolean insert(Customer customer) throws SQLException {
        try (SqlSession session = DaoMyBatisConfig.getSessionFactory().openSession(true)) {
            int rowsAffected = session.insert("homework.bank.dao.Dao.insert", customer);
            return rowsAffected > 0;
        }
    }

    @Override
    public void update(Customer customer, Integer id) throws SQLException {
        try (SqlSession session = DaoMyBatisConfig.getSessionFactory().openSession(true)) {
            Map<String, Object> params = new HashMap<>();
            params.put("customer", customer);
            params.put("id", id);
            session.update("homework.bank.dao.Dao.update", params);
        }
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        try (SqlSession session = DaoMyBatisConfig.getSessionFactory().openSession(true)) {
            int rowsAffected = session.delete("homework.bank.dao.Dao.delete", id);
            return rowsAffected > 0;
        }
    }
}
