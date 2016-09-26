package ua.adeptius.jdbc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Entity
public class Waiter extends Employee {

    //@Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.EAGER)//fetch = FetchType.LAZY
    @JoinColumn(name = "employee_id")
    private List<Order> orders;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Waiter {\n");
        sb.append("   id = ").append(id).append("\n");
        sb.append("   name = ").append(name).append("\n");
        sb.append("   surname = ").append(surname).append("\n");
        sb.append("   orders = {\n");
        orders.forEach(order -> sb.append("   	").append(order).append("\n"));
        sb.append(" )\n");
        sb.append(")\n");
        return sb.toString();
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
