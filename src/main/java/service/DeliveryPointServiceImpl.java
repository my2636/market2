package service;

import entity.DeliveryPoint;
import repository.DeliveryPointRepository;
import repository.DeliveryPointRepositoryImpl;

import java.util.Arrays;
import java.util.List;

public class DeliveryPointServiceImpl implements DeliveryPointService {
    DeliveryPointRepository deliveryPointRepository;

    public DeliveryPointServiceImpl() {
        this.deliveryPointRepository = new DeliveryPointRepositoryImpl();
    }

    @Override
    public void addDeliveryPoints(DeliveryPoint... deliveryPoints) {
        if (deliveryPoints == null || deliveryPoints.length == 0) {
            throw new IllegalArgumentException("Delivery points array cannot be null or empty.");
        }
        deliveryPointRepository.addList(Arrays.asList(deliveryPoints));
    }

    public List<DeliveryPoint> getList() {
        return deliveryPointRepository.getList();
    }

    public DeliveryPoint getByNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        return deliveryPointRepository.getByNumber(number);
    }

}
