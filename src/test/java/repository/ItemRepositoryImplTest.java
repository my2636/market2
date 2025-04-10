package repository;

import entity.Item;
import enums.Category;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemRepositoryImplTest {

    @Test
    void testAddItemList() {
        ItemRepositoryImpl repository = new ItemRepositoryImpl();
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("first", Category.CLOTHES, 6.0));
        itemList.add(new Item("second", Category.HOME, 70.1));

        repository.addItemList(itemList);
        assertEquals(2, repository.getList().size());
        assertEquals(itemList.get(0), repository.getList().get(0));
        assertEquals(itemList.get(1), repository.getList().get(1));
    }


    @Test
    void testGetList() {
        ItemRepositoryImpl repository = new ItemRepositoryImpl();
        List<Item> items = new ArrayList<>();
        items.add(new Item("first", Category.CLOTHES, 6.0));
        repository.addItemList(items);

        assertEquals(items, repository.getList());
    }

    @Test
    void testDelete() {
        ItemRepositoryImpl repository = new ItemRepositoryImpl();
        Item item1 = new Item("first", Category.CLOTHES, 6.0);
        Item item2 = new Item("second", Category.HOME, 70.1);
        repository.addItemList(List.of(item1, item2));

        repository.delete(item1);
        assertEquals(1, repository.getList().size());
        assertEquals(item2, repository.getList().get(0));

        repository.delete(new Item("third", Category.FOOD, 50.2)); // удаление несуществующего элемента.
        assertEquals(1, repository.getList().size());
    }


    @Test
    void testDeleteList() {
        ItemRepositoryImpl repository = new ItemRepositoryImpl();
        Item item1 = new Item("G", Category.FOOD, 70);
        Item item2 = new Item("H", Category.APPLIANCES, 80);
        Item item3 = new Item("I", Category.FOOTWEAR, 90);

        repository.addItemList(List.of(item1, item2, item3));
        repository.deleteList(List.of(item1, item3));
        assertEquals(1, repository.getList().size());
        assertEquals(item2, repository.getList().get(0));

        repository.deleteList(List.of(new Item("J", Category.HOME, 100))); // удаление несуществующего элемента
        assertEquals(1, repository.getList().size());
    }

    @Test
    void testEmptyList() {
        ItemRepositoryImpl repository = new ItemRepositoryImpl();
        assertTrue(repository.getList().isEmpty());
    }

    @Test
    void testNullListAddition() {
        ItemRepositoryImpl repository = new ItemRepositoryImpl();
        assertDoesNotThrow(() -> repository.addItemList(null)); // null не вызывает исключения, просто ничего не добавляет.
        assertTrue(repository.getList().isEmpty());

    }


    @Test
    void testDeleteNullItem() {
        ItemRepositoryImpl repository = new ItemRepositoryImpl();
        assertDoesNotThrow(() -> repository.delete(null)); //null не вызывает исключения
    }


    @Test
    void testDeleteNullList() {
        ItemRepositoryImpl repository = new ItemRepositoryImpl();
        assertDoesNotThrow(() -> repository.deleteList(null)); // null не вызывает исключения
    }
}
