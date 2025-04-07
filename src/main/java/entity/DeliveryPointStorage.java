package entity;

public class DeliveryPointStorage extends Storage<Order>{
    String city;
    String localAddress;    // улица, дом

    public DeliveryPointStorage(String city, String localAddress) {
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
}