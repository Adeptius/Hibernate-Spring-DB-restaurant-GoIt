package ua.adeptius.jdbc.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.adeptius.jdbc.dao.OrderDao;
import ua.adeptius.jdbc.model.Orders;

import java.util.List;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }

    @Override
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Orders").executeUpdate();
    }
}
