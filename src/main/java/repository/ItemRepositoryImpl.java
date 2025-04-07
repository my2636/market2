package repository;

import entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemRepositoryImpl implements ItemRepository{
    List<Item> items = new ArrayList<>();

    @Override
    public void addItem(Item item) {

    }

    @Override
    public void addItems(Item... addedItems) {

    }

    @Override
    public void addItemList(List<Item> itemList) {

    }


    @Override
    public Item getById(UUID itemId) {
        return null;
    }

    @Override
    public void deleteById(UUID itemId) {

    }
}
