package repository;

import entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    void addOrder(Order order);

    Order getByNumber(int orderNumber);

    List<Order> getList();

    void deleteById(UUID orderId);
}