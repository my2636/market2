package entity;

import enums.OrderStatus;

import java.util.UUID;
import java.util.List;

public class Order {
    private final UUID id;
    private final UUID userId;
    private OrderStatus status;
    private final UUID deliveryPointId;
    private final List<Item> itemList;
    private final double totalPrice;

    public Order(UUID userId, UUID deliveryPointId, List<Item> itemList) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.status = OrderStatus.CREATED;
        this.deliveryPointId = deliveryPointId;
        this.itemList = itemList;
        this.totalPrice = itemList
                .stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public UUID getDeliveryPointId() {
        return deliveryPointId;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "\nСтатус: " + getStatus() +
                "\nПользователь: " + getUserId() +
                "\nПункт выдачи: " + getDeliveryPointId() +
                "\nСписок товаров: " + getItemList() +
                "\nСумма заказа: " + getTotalPrice();
    }
}
