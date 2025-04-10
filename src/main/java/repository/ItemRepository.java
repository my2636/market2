package repository;

import entity.Item;

import java.util.List;
import java.util.UUID;


public interface ItemRepository {
    void addItemList(List<Item> itemList);

    List<Item> getList();

    void delete(Item item);

    void deleteList(List<Item> deletingItems);
}