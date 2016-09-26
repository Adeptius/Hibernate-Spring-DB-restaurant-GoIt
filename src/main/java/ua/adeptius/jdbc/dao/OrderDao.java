package ua.adeptius.jdbc.dao;

import ua.adeptius.jdbc.model.Orders;

import java.util.List;

public interface OrderDao {

    void save(Orders orders);

    List<Orders> findAllOrders();

}
