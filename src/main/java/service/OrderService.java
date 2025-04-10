package service;

import entity.Item;
import entity.Order;

import java.util.List;
import java.util.UUID;


public interface OrderService extends Showable<Order> {
    void createOrder(UUID userId, UUID deliveryPointId, List<Item> itemList);

    Order getOrderByNumber(int number);

    List<Order> getList();
}
