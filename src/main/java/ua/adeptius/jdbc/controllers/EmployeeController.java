package ua.adeptius.jdbc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.jdbc.model.Employee;
import ua.adeptius.jdbc.dao.EmployeeDao;
import ua.adeptius.jdbc.model.Position;
import ua.adeptius.jdbc.model.Waiter;

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
//        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());
//        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setName("John");
//        employee.setSurname("Smith");
//        employee.setPosition(Position.WAITER);
//        employee.setPhoneNumber("555-55-55");
//        employee.setSalary(25000.0F);
//        employeeDao.save(employee);
    }

    @Transactional
    public void initEmployees() {
        Waiter john = new Waiter();
        john.setId(1L);
        john.setName("John");
        john.setSurname("Smith");
        john.setPosition(Position.WAITER);
        john.setPhoneNumber("555-55-55");
        john.setSalary(25000.0F);
        employeeDao.save(john);

        Waiter mary = new Waiter();
        mary.setId(1L);
        mary.setName("Mary");
        mary.setSurname("Smith");
        mary.setPosition(Position.WAITER);
        mary.setPhoneNumber("444-44-44");
        mary.setSalary(30000.0F);
        employeeDao.save(mary);
    }

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String name){
        return employeeDao.findByName(name);
    }

    @Transactional
    public void printAllEmployees() {
        getAllEmployees().forEach(System.out::println);
    }

    @Transactional
    public void removeAllEmployee() {
        employeeDao.removeAll();
    }

    @Transactional
    public void printEmployee(long i) {
        System.out.println(employeeDao.load(i));
    }
}
