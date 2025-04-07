package entity;

import enums.OrderStatus;

import java.util.UUID;
import java.util.List;

public class Order {
    private UUID id;
    private UUID userStorageId;
    private OrderStatus status;
    private UUID deliveryPointId;
    private List<Item> itemList;
    private double totalPrice;

    public Order(UUID userStorageId, UUID deliveryPointId, List<Item> itemList) {
        this.id = UUID.randomUUID();
        this.userStorageId = userStorageId;
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

    public OrderStatus getStatus() {
        return status;
    }

    public UUID getDeliveryPointId() {
        return deliveryPointId;
    }

    public List<Item> getOrderItemList() {
        return itemList;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nСтатус: " + status +
                "\nАдрес: " + deliveryPointId +
                "\nСписок товаров: " + itemList +
                "\nСумма заказа: " + totalPrice;
    }
}
