package service;

import entity.Item;
import entity.Order;

import java.util.List;
import java.util.UUID;


public interface OrderService {
    void createOrder(UUID userId, UUID deliveryPointId, List<Item> itemList);

    void showOrdersByUserId(UUID userId);

    Order getOrderByNumber(int number);

    List<Order> getOrdersByUserId(UUID userId);

    List<Order> getOrders();
}
