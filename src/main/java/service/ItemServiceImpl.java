package service;

import entity.Item;
import repository.ItemRepository;
import repository.ItemRepositoryImpl;

import java.util.ArrayList;
import java.util.List;


public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository = new ItemRepositoryImpl();

    public void addList(List<Item> addingList) {
        if (addingList != null) {
            itemRepository.addItemList(addingList);
        }
    }

    public List<Item> getList() {
        return itemRepository.getList();
    }

    public List<Item> getListByNumbers(int... itemNumbers) {
        List<Item> items = itemRepository.getList();
        List<Item> chosenItems = new ArrayList<>();
        int index = 0;
        for (int i : itemNumbers) {
            if (i <= 0 || i > items.size()) {
                throw new IllegalArgumentException("Invalid index: " + i);
            }
            chosenItems.add(items.get(index++));
        }
        return chosenItems;
    }

    public void deleteByNumbers(int... itemNumbers) {
        List<Item> items = itemRepository.getList();
        int index = 0;
        for (int i : itemNumbers) {
            if (i <= 0 ) {
                throw new IllegalArgumentException("Invalid index: " + i);
            }
            itemRepository.delete(items.get(index++));
        }
    }

    public void deleteList(List<Item> deletingList) {
        if (deletingList != null) {
            itemRepository.deleteList(deletingList);
        }
    }
}
