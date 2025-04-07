package service;

import entity.Item;
import entity.Order;
import enums.OrderStatus;
import repository.OrderRepository;
import repository.OrderRepositoryImpl;

import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;

    public OrderServiceImpl() {
        this.orderRepository = new OrderRepositoryImpl();
    }

    @Override
    public void createOrder(UUID userStorageId, UUID deliveryPointId, List<Item> itemList) {
        orderRepository.addOrder(new Order(userStorageId, deliveryPointId, itemList));
    }

    @Override
    public OrderStatus checkStatus(Order order) {
        return order.getStatus();
    }

    @Override
    public void changeStatus(Order order, OrderStatus newStatus) {

    }
}
