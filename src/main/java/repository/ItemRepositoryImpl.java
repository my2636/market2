package repository;

import entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemRepositoryImpl implements ItemRepository {
    List<Item> items = new ArrayList<>(0);

    @Override
    public void addItem(Item item) {

    }

    @Override
    public void addItemList(List<Item> itemList) {
        items.addAll(itemList);
    }

    @Override
    public Item getById(UUID itemId) {
        return items
                .stream()
                .filter(x -> itemId.equals(x.getId()))
                .findFirst()
                .get();
    }

    @Override
    public List<Item> getList() {
        return items;
    }

    @Override
    public void delete(Item item) {
        items.remove(item);
    }

    @Override
    public void deleteById(UUID itemId) {
        items.removeIf(x -> itemId.equals(x.getId()));
    }

    @Override
    public void deleteList(List<Item> deletingItems) {
        items.removeAll(deletingItems);
    }
}
