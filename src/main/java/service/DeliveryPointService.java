package service;

import entity.Order;

public interface DeliveryPointService {
    void takeInputOrder(Order order);
    void giveOrderById();
}
