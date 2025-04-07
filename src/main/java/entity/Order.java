package entity;

import enums.OrderStatus;

import java.util.UUID;
import java.util.List;

public class Order {
    private UUID id;
    private OrderStatus status;
    private String address;
    private List<Item> itemList;
    private double totalPrice;

    public Order(String address, List<Item> itemList) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.CREATED;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public List<Item> getOrderItemList() {
        return itemList;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  "\nСтатус: " + status +
                "\nАдрес: " + address +
                "\nСписок товаров: " + itemList +
                "\nСумма заказа: " + totalPrice;
    }
}
