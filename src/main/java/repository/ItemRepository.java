package repository;

import entity.Item;

import java.util.List;
import java.util.UUID;


public interface ItemRepository {
    void addItem(Item addingItem);

    void addItemList(List<Item> itemList);

    Item getById(UUID itemId);

    List<Item> getList();

    void delete(Item item);

    void deleteById(UUID itemId);

    void deleteList(List<Item> deletingItems);
}