package service;

import entity.Item;
import enums.Category;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.ItemRepository;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ItemServiceImplTest {

    @Test
    void addList_addsItemsToRepository() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl();
        List<Item> items = Arrays.asList(new Item("Item 1", Category.CLOTHES, 60.9), new Item("Item 2", Category.APPLIANCES, 65.9));

        service.addList(items);

        verify(repository).addItemList(items);
    }

    @Test
    void addList_doesNothingForNullList() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl();

        service.addList(null);

        verify(repository, never()).addItemList(anyList());
    }

    @Test
    void getList_returnsItemsFromRepository() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl();
        List<Item> items = Arrays.asList(new Item("Item 1", Category.CLOTHES, 60.9), new Item("Item 2", Category.APPLIANCES, 65.9));
        when(repository.getList()).thenReturn(items);

        List<Item> result = service.getList();

        assertEquals(items, result);
    }

    @Test
    void getListByNumbers_returnsCorrectItems() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl();
        List<Item> items = Arrays.asList(new Item("Item 1", Category.CLOTHES, 60.9), new Item("Item 2", Category.APPLIANCES, 65.9), new Item("Item 3", Category.APPLIANCES, 159.9));
        when(repository.getList()).thenReturn(items);

        List<Item> result = service.getListByNumbers(1, 3);

        assertEquals(Arrays.asList(items.get(0), items.get(2)), result);
    }

    @Test
    void getListByNumbers_throwsExceptionForInvalidIndex() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl();
        List<Item> items = Arrays.asList(new Item("Item 1", Category.CLOTHES, 60.9), new Item("Item 2", Category.APPLIANCES, 65.9));
        when(repository.getList()).thenReturn(items);

        assertThrows(IllegalArgumentException.class, () -> service.getListByNumbers(3)); // Индекс вне диапазона
        assertThrows(IllegalArgumentException.class, () -> service.getListByNumbers(0)); // Индекс 0
        assertThrows(IllegalArgumentException.class, () -> service.getListByNumbers(-1)); // Отрицательный индекс
    }


    @Test
    void deleteByNumbers_deletesCorrectItems() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl();
        List<Item> items = Arrays.asList(new Item("Item 1", Category.CLOTHES, 60.9), new Item("Item 2", Category.APPLIANCES, 65.9), new Item("Item 3", Category.APPLIANCES, 159.9));
        when(repository.getList()).thenReturn(items);

        service.deleteByNumbers(1, 3);

        verify(repository).delete(items.get(0));
        verify(repository).delete(items.get(2));
    }


    @Test
    void deleteByNumbers_throwsExceptionForInvalidIndex() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl();
        List<Item> items = Arrays.asList(new Item("Item 1", Category.CLOTHES, 60.9), new Item("Item 2", Category.APPLIANCES, 65.9));
        when(repository.getList()).thenReturn(items);

        assertThrows(IllegalArgumentException.class, () -> service.deleteByNumbers(3));
        assertThrows(IllegalArgumentException.class, () -> service.deleteByNumbers(0));
        assertThrows(IllegalArgumentException.class, () -> service.deleteByNumbers(-1));
    }

    @Test
    void deleteList_deletesItemsFromRepository() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl();
        List<Item> items = Arrays.asList(new Item("Item 1", Category.CLOTHES, 60.9), new Item("Item 2", Category.APPLIANCES, 65.9));

        service.deleteList(items);

        verify(repository).deleteList(items);
    }

    @Test
    void deleteList_doesNothingForNullList() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemServiceImpl service = new ItemServiceImpl();

        service.deleteList(null);

        verify(repository, never()).deleteList(anyList());
    }
}