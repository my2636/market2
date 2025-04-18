package entity;

import enums.Category;

import java.util.Objects;
import java.util.UUID;

public class Item {
    private UUID id;
    private String name;
    private Category category;
    private double price;

    public Item(String name, Category category, double price) {
        this.id = UUID.randomUUID();
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.category = Objects.requireNonNull(category, "Category cannot be null");
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Item item = (Item) object;
        return Double.compare(price, item.price) == 0 && Objects.equals(id, item.id) && Objects.equals(name, item.name) && category == item.category;
    }

    @Override
    public String toString() {
        return "\nНазвание: " + name +
                "\nКатегория: " + category +
                "\nЦена: " + price;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price);
    }
}
