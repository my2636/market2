package repository;

import entity.DeliveryPoint;
import entity.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryPointRepositoryImpl implements DeliveryPointRepository{
    List<DeliveryPoint> points = new ArrayList<>();

    @Override
    public void add(DeliveryPoint deliveryPoint) {
        points.add(deliveryPoint);
    }

    @Override
    public void addList(List<DeliveryPoint> deliveryPoints) {
        points.addAll(deliveryPoints);
    }

    @Override
    public List<DeliveryPoint> getList() {
        return points;
    }

    @Override
    public void delete(DeliveryPoint deliveryPoint) {
        points.remove(deliveryPoint);
    }
}
