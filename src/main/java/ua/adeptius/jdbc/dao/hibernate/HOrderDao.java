package ua.adeptius.jdbc.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.adeptius.jdbc.dao.OrderDao;
import ua.adeptius.jdbc.model.Order;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o").list();
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Order").executeUpdate();
    }

}
