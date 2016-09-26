package ua.adeptius.jdbc.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.jdbc.model.Employee;
import ua.adeptius.jdbc.dao.EmployeeDao;

import java.util.List;

public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional // Включаем поддержку сессий
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee load(Long id) {
        return null;
    }

    @Override
    public Employee findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name");
        query.setParameter("name", name);
        return (Employee) query.uniqueResult();
    }

    @Override
    public List<Employee> findAll() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list();
    }

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }
}
