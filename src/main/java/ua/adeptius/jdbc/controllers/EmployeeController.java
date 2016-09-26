package ua.adeptius.jdbc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.jdbc.model.Employee;
import ua.adeptius.jdbc.dao.EmployeeDao;
import ua.adeptius.jdbc.model.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeController {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional // Включаем поддержку сессий
    public void createEmployee(){
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);
        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);
        }
    }

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String name){
        return employeeDao.findByName(name);
    }
}