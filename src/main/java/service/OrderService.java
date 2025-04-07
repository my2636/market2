package service;

import entity.Item;
import entity.Order;
import enums.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    void createOrder(UUID userStorageId, UUID deliveryPointId, List<Item> itemList);

    OrderStatus checkStatus(Order order);

    void changeStatus(Order order, OrderStatus newStatus);
}
