package entity;

import java.util.UUID;

public class DeliveryPoint {
    UUID id;
    String city;
    String localAddress;    // улица, дом

    public DeliveryPoint(String city, String localAddress) {
        this.id = UUID.randomUUID();
        this.city = city;
        this.localAddress = localAddress;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public String getCity() {
        return city;
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