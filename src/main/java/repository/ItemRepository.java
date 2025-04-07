package repository;

import entity.Item;

import java.util.List;
import java.util.UUID;


public interface ItemRepository {
    void addItem(Item addedItem);
    void addItems(Item ... addedItems);
    void addItemList(List<Item> itemList);
    Item getById(UUID itemId);
    void deleteById(UUID itemId);
}