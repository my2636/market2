package repository;

import entity.DeliveryPoint;
import entity.Item;

import java.util.List;

public interface DeliveryPointRepository {
    void add(DeliveryPoint deliveryPoint);

    void addList(List<DeliveryPoint> deliveryPoints);

    List<DeliveryPoint> getList();

    void delete(DeliveryPoint deliveryPoint);
}
