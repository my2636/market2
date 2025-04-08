package service;

import entity.DeliveryPoint;
import entity.Order;

import java.util.List;

public interface DeliveryPointService {
    void addDeliveryPoints(DeliveryPoint... deliveryPoints);

    void showList();

    DeliveryPoint getByNumber(int number);

    List<DeliveryPoint> getList();

    void deletePoint(DeliveryPoint deliveryPoint);
}
