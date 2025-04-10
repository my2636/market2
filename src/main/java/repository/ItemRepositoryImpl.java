package repository;

import entity.Item;

import java.util.ArrayList;
import java.util.List;


public class ItemRepositoryImpl implements ItemRepository {
    private final List<Item> items = new ArrayList<>();

    @Override
    public void addItemList(List<Item> itemList) {
        if (itemList != null) {
            items.addAll(itemList);
        }
    }

    @Override
    public List<Item> getList() {
        return items; // Возвращаем копию
    }

    @Override
    public void delete(Item item) {
        if (item != null) {
            items.remove(item);
        }
    }

    @Override
    public void deleteList(List<Item> deletingItems) {
        if (deletingItems != null) {
            items.removeAll(deletingItems);
        }
    }
}
