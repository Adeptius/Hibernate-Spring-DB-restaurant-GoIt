package ua.adeptius.jdbc.dao;

import ua.adeptius.jdbc.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();

    void remove(Employee employee);

    Employee findByName(String name);

    void removeAll();
}
