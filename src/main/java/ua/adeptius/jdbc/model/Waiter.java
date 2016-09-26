package ua.adeptius.jdbc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Entity
public class Waiter extends Employee {

    //@Fetch(FetchMode.JOIN)
    @OneToMany()//fetch = FetchType.LAZY
    @JoinColumn(name = "employee_id")
    private List<Order> orders;

    @Override
    public String toString() {
        return "Waiter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                "orders=" + (orders.size()) +
                '}';
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
