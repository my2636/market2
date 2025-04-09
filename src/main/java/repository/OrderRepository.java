package repository;

import entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    void addOrder(Order order);

    Order getById(UUID orderId);

    Order getByNumber(int orderNumber);

    List<Order> getOrders();

    void deleteById(UUID orderId);
}