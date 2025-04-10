package repository;

import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository {
    List<Order> orders = new ArrayList<>(0);

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public Order getByNumber(int orderNumber) {
        return orders.get(orderNumber);
    }

    @Override
    public List<Order> getList() {
        return orders;
    }


    @Override
    public void deleteById(UUID orderId) {
        orders.removeIf(x -> orderId.equals(x.getId()));
    }


}
