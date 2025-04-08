package repository;

import entity.Order;

import java.util.UUID;

public interface OrderRepository {
    void addOrder(Order order);

    Order getById(UUID orderId);

    Order getByNumber(int orderNumber);

    void deleteById(UUID orderId);
}