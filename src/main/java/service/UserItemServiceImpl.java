package service;

import entity.Item;
import repository.ItemRepository;
import repository.ItemRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class UserItemServiceImpl implements ItemService {
    ItemRepository userItemRepository = new ItemRepositoryImpl();

    @Override
    public void addList(List<Item> addingList) {
        userItemRepository.addItemList(addingList);
    }

    @Override
    public void addItems(Item... items) {

    }

    @Override
    public List<Item> getList() {
        return userItemRepository.getList();
    }

    @Override
    public List<Item> getListByNumbers(int... itemNumbers) {
        List<Item> items = userItemRepository.getList();
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

    @Override
    public void deleteByNumbers(int... itemNumbers) {
        List<Item> items = userItemRepository.getList();
        for (int i : itemNumbers) {
            Item item = items.get(i - 1);
            userItemRepository.delete(item);
        }
    }

    @Override
    public void deleteList(List<Item> deletingList) {
        userItemRepository.deleteList(deletingList);
    }
}
