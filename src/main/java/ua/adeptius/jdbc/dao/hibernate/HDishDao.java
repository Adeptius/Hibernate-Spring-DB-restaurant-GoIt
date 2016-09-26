package ua.adeptius.jdbc.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.jdbc.dao.DishDao;
import ua.adeptius.jdbc.model.Dish;
import ua.adeptius.jdbc.model.Employee;

import java.util.List;

public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Dish dish) {
        Session session = sessionFactory.getCurrentSession();
        session.save(dish);
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Dish e where e.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Dish> findall() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select d from Dish d").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
