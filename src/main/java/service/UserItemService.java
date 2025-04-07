package service;

import entity.Item;
import repository.ItemRepository;
import repository.ItemRepositoryImpl;

import java.util.List;

public class UserItemService implements ItemService {
    ItemRepository userItemRepository = new ItemRepositoryImpl();

    @Override
    public void addList(List<Item> addingList) {

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
    public void deleteByNumbers(int... itemNumbers) {
        for (int i : itemNumbers) {
            userItemRepository.delete(userItemRepository.getList().get(i - 1));
        }
    }

    @Override
    public void deleteList(List<Item> deletingList) {
        userItemRepository.deleteList(deletingList);
    }
}
