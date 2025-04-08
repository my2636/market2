package service;

import entity.Item;
import repository.ItemRepository;
import repository.ItemRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserItemService implements ItemService {
    ItemRepository userItemRepository;

    public UserItemService(UUID userId) {
        this.userItemRepository = new ItemRepositoryImpl();

    }

    public UserItemService() {

    }

    @Override
    public void addList(List<Item> addingList) {
        userItemRepository.addItemList(addingList);
    }

    @Override
    public void showItems() {
        List<Item> items = userItemRepository.getList();
        if (items.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (Item i : items) {
            System.out.println("\n" + (items.indexOf(i) + 1) + ". " + i.toString());
        }
    }

    @Override
    public List<Item> getList() {
        return List.of();
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
