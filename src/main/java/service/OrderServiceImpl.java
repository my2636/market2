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
    public void showOrdersByUserId(UUID userId) {
        List<Order> userOrders = orderRepository.getOrders()
                .stream()
                .filter(x -> userId.equals(x.getUserId()))
                .toList();

        if (userOrders.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (Order o : userOrders) {
            System.out.println("\n" + (userOrders.indexOf(o) + 1) + ". " + o.toString());
        }
    }

    @Override
    public Order getOrderByNumber(int number) {
        return orderRepository.getByNumber(number);
    }

    @Override
    public List<Order> getOrdersByUserId(UUID userId) {
        return orderRepository.getOrders()
                .stream()
                .filter(x -> userId.equals(x.getUserId()))
                .toList();
    }

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }
}
