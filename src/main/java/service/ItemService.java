package service;

import entity.Item;

import java.util.List;

public interface ItemService {
    void addList(List<Item> addingList);

    void showItems();

    List<Item> getList();

    void deleteByNumbers(int... itemNumbers);

    void deleteList(List<Item> deletingList);
}
