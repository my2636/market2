package service;

import entity.Item;
import repository.ItemRepository;
import repository.ItemRepositoryImpl;

import java.util.ArrayList;
import java.util.List;


public class ItemServiceImpl implements ItemService {

    ItemRepository marketItemRepository = new ItemRepositoryImpl();

    public void addList(List<Item> addingList) {
        marketItemRepository.addItemList(addingList);
    }

    public List<Item> getList() {
        return marketItemRepository.getList();
    }

    public List<Item> getListByNumbers(int... itemNumbers) {
        List<Item> items = marketItemRepository.getList();
        List<Item> chosenItems = new ArrayList<>();
        for (int i : itemNumbers) {
            if (i > 0 && i <= items.size()) {
                chosenItems.add(items.get(i - 1));
            } else {
                System.out.println("Неверный индекс: " + i);
            }
        }
        return chosenItems;
    }

    public void deleteByNumbers(int... itemNumbers) {
        for (int i : itemNumbers) {
            marketItemRepository.delete(marketItemRepository.getList().get(i - 1));
        }
    }

    public void deleteList(List<Item> deletingList) {
        marketItemRepository.deleteList(deletingList);
    }
}
