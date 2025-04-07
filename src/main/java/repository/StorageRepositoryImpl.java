package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class StorageRepositoryImpl<Storage> implements StorageRepository<Storage> {
    List<Storage> storages = new ArrayList<>();


    @Override
    public void add(Storage storage) {
        storages.add(storage);
    }

    @Override
    public void addStorages(Storage ... addingStorages) {
        storages.addAll(Arrays.asList(addingStorages));
    }

    /*@Override
    public List<DeliveryPointStorage> getPointsByCity(String city) {
        return positionList
                .stream()
                .filter(x -> x.getCity().equals(city))
                .toList();
    }*/

    @Override
    public List<Storage> getStorages() {
        return storages;
    }

    @Override
    public void delete(Storage storage) {
        storages.remove(storage);
    }

    public void deleteById(UUID deletingStorageId) {
        storages.removeIf(x -> x.);
    }

    @Override
    public void deleteList(List<Storage> deletingPositioList) {
        storages.removeAll(deletingPositioList);
    }
}
