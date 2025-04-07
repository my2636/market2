package repository;

import java.util.List;
import java.util.UUID;

public interface StorageRepository<Storage> {
    void add(Storage storage);
    void addStorages(Storage ... storages);
    List<Storage> getStorages();
    void delete(Storage storage);
    void deleteById(UUID deletingStorageId);
    void deleteList(List<Storage> deletingPointList);
}
