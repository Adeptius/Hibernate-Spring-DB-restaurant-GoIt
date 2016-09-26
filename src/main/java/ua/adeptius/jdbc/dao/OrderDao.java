package ua.adeptius.jdbc.dao;

import ua.adeptius.jdbc.model.Order;

import java.util.List;

public interface OrderDao {

    void save(Order order);

    List<Order> findAllOrders();

    void removeAll();

}
