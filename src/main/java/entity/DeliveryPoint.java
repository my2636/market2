package entity;

import java.util.Objects;
import java.util.UUID;

public class DeliveryPoint {
    UUID id;
    String city;
    String localAddress;    // улица, дом

    public DeliveryPoint(String city, String localAddress) {
        this.id = UUID.randomUUID();
        this.city = Objects.requireNonNull(city, "City cannot be null"); // Проверка на null
        this.localAddress = Objects.requireNonNull(localAddress, "Local address cannot be null");
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public String getCity() {
        return city;
    }

    public UUID getId() {
        return id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    @Override
    public String toString() {
        return "\nПункт выдачи" +
                "\nГород: " + city + '\'' +
                "\nАдрес: " + localAddress;
    }
}