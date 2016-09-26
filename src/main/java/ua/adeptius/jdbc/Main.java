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
    private boolean reInit;

    public void setReInit(boolean reInit) {
        this.reInit = reInit;
    }

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
        init();
    }

    public void init(){
        if (reInit){
            orderController.removeAllOrders();
            dishController.removeAllDishes();
            employeeController.removeAllEmployee();

            dishController.initDishes();
            employeeController.initEmployees();
            orderController.initOrders();

            employeeController.printAllEmployees();
            //orderController.printAllOrders();
//            employeeController.getAllEmployees().forEach(System.out::println);
        }
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
