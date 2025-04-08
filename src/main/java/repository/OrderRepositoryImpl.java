package repository;

import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository {
    List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public Order getById(UUID orderId) {
        return orders
                .stream()
                .filter(x -> orderId.equals(x.getId()))
                .findFirst()
                .get();
    }

    @Override
    public Order getByNumber(int orderNumber) {
        return orders.get(orderNumber);
    }

    @Override
    public void deleteById(UUID orderId) {
        orders.removeIf(x -> orderId.equals(x.getId()));
    }
}
