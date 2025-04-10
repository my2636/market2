package service;

import entity.Item;
import entity.Order;
import repository.OrderRepository;
import repository.OrderRepositoryImpl;

import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public void createOrder(UUID userId, UUID deliveryPointId, List<Item> itemList) {
        orderRepository.addOrder(new Order(userId, deliveryPointId, itemList));
    }

    @Override
    public Order getOrderByNumber(int number) {
        return orderRepository.getByNumber(number);
    }

    public List<Order> getList() {
        return orderRepository.getList();
    }
}
