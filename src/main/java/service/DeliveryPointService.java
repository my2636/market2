package service;

import entity.DeliveryPoint;
import entity.Order;

import java.util.List;

public interface DeliveryPointService extends Showable<DeliveryPoint> {
    void addDeliveryPoints(DeliveryPoint... deliveryPoints);

    DeliveryPoint getByNumber(int number);

    List<DeliveryPoint> getList();

}
