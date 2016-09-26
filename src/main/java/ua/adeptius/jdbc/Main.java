package ua.adeptius.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.adeptius.jdbc.controllers.DishController;
import ua.adeptius.jdbc.controllers.EmployeeController;
import ua.adeptius.jdbc.controllers.OrderController;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml", "hibernate-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        employeeController.createEmployee();
        dishController.createDish();
        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salat");
        orderController.createOrder("John", dishes1,1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Salat");
        dishes2.add("Potato");

        orderController.createOrder("John", dishes2,2);

        orderController.printAllOrders();
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
