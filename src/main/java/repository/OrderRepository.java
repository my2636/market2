package repository;

import entity.Item;
import entity.Order;

import java.util.UUID;

public interface OrderRepository {
    void addOrder(Order order);
    Order getById(UUID orderId);
    void deleteById(UUID orderId);
}