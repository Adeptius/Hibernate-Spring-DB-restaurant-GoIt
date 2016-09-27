package ua.adeptius.jdbc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.jdbc.dao.DishDao;
import ua.adeptius.jdbc.dao.EmployeeDao;
import ua.adeptius.jdbc.dao.OrderDao;
import ua.adeptius.jdbc.model.Dish;
import ua.adeptius.jdbc.model.DishCategory;
import ua.adeptius.jdbc.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController {

    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    public void createOrder(String waiterName,
                            List<String> dishes, int tableNumber){
        Order order = new Order();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDate(new Date());
        orderDao.save(order);
    }

    @Transactional
    public void printAllOrders() {
        getAllOrders().forEach(System.out::println);
    }

    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dish : dishes) {
            result.add(dishDao.findByName(dish));
        }
        return result;
    }

    @Transactional
    public List<Order> getAllOrders(){
        return orderDao.findAllOrders();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public void removeAllOrders() {
        orderDao.removeAll();
    }

    @Transactional
    public void initOrders() {
        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salat");
        createOrder("John", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Salat");
        dishes2.add("Potato");
        createOrder("John", dishes2, 2);

        List<String> dishes3 = new ArrayList<>();
        dishes2.add("Plov");
        dishes2.add("Potato");
        createOrder("Mary", dishes3, 3);

        orderDao.save(createOrderWithIceCream());
    }

    private Order createOrderWithIceCream() {
        List<Dish> dishes4 = new ArrayList<>();
        Dish iceCream = new Dish();
        iceCream.setName("Ice Cream");
        iceCream.setCategory(DishCategory.DESERT);
        iceCream.setPrice(3.0F);
        dishes4.add(iceCream);

        Order order = new Order();
        order.setWaiter(employeeDao.findByName("Mary"));
        order.setDishes(dishes4);
        order.setTableNumber(4);
        order.setOrderDate(new Date());
        return order;

    }
}
