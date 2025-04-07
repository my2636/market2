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
        deliveryPointRepository.addList(Arrays.asList(deliveryPoints));
    }

    public void showItems() {
        List<DeliveryPoint> items = deliveryPointRepository.getList();
        if (items.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (DeliveryPoint i : items) {
            System.out.println("\n" + (items.indexOf(i) + 1) + ". " + i.toString());
        }
    }

    @Override
    public List<DeliveryPoint> getList() {
        return deliveryPointRepository.getList();
    }

    @Override
    public void deletePoint(DeliveryPoint deliveryPoint) {
        deliveryPointRepository.delete(deliveryPoint);
    }

}
