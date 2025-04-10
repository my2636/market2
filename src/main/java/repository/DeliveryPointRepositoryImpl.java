package repository;

import entity.DeliveryPoint;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPointRepositoryImpl implements DeliveryPointRepository {
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
    public DeliveryPoint getByNumber(int number) {
        return points.get(number - 1);
    }

    @Override
    public List<DeliveryPoint> getList() {
        return points;
    }

    public List<DeliveryPoint> getListByCity(String city) {
        return points
                .stream()
                .filter(x -> city.equals(x.getCity()))
                .toList();
    }

    @Override
    public void delete(DeliveryPoint deliveryPoint) {
        points.remove(deliveryPoint);
    }
}
