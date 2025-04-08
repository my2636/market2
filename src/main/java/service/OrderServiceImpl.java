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
    public void createOrder(UUID userId, UUID deliveryPointId, List<Item> itemList) {
        orderRepository.addOrder(new Order(userId, deliveryPointId, itemList));
    }

    @Override
    public void showOrdersByUserId(UUID userId) {

    }

    @Override
    public Order getOrderByNumber(int number) {
        return orderRepository.getByNumber(number);
    }

    @Override
    public List<Order> getOrdersByUserId(UUID userId) {
        return List.of();
    }
}
