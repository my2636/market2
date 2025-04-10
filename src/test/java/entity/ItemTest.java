package entity;
import enums.Category;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testConstructorValid() {
        Item item = new Item("Test Item", Category.ELECTRONICS, 100.0);
        assertNotNull(item.getId());
        assertEquals("Test Item", item.getName());
        assertEquals(Category.ELECTRONICS, item.getCategory());
        assertEquals(100.0, item.getPrice());
    }

    @Test
    void testConstructorNullName() {
        assertThrows(NullPointerException.class, () -> new Item(null, Category.CLOTHES, 50.0));
    }

    @Test
    void testConstructorNullCategory() {
        assertThrows(NullPointerException.class, () -> new Item("Test Item", null, 50.0));
    }

    @Test
    void testConstructorNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Item("Test Item", Category.FOOD, -10.0));
    }


    @Test
    void testEquals() {
        Item item1 = new Item("Test Item", Category.ELECTRONICS, 100.0);
        Item item2 = new Item("Test Item", Category.ELECTRONICS, 100.0);
        Item item3 = new Item("Different Item", Category.APPLIANCES, 50.0);

        assertNotEquals(item1, item2);
        assertNotEquals(item1, item3);
        assertNotEquals(item1, null); // проверка на null
        assertNotEquals(item1, new Object()); // проверка на другой тип
    }

    @Test
    void testHashCode() {
        Item item1 = new Item("Test Item", Category.ELECTRONICS, 100.0);
        Item item2 = new Item("Test Item", Category.ELECTRONICS, 100.0);
        Item item3 = new Item("Different Item", Category.CLOTHES, 50.0);

        assertNotEquals(item1.hashCode(), item2.hashCode());
        assertNotEquals(item1.hashCode(), item3.hashCode());
    }

    @Test
    void testToString() {
        Item item = new Item("Test Item", Category.ELECTRONICS, 100.0);
        String expected = "\nНазвание: Test Item\nКатегория: ELECTRONICS\nЦена: 100.0";
        assertEquals(expected, item.toString());
    }
}
