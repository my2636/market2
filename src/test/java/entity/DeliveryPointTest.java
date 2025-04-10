package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DeliveryPointTest {

    @Test
    void testConstructor() {
        String city = "Москва";
        String address = "ул. Зеленина, 1";
        DeliveryPoint point = new DeliveryPoint(city, address);

        assertNotNull(point.getId()); // Проверяем, что ID сгенерирован
        assertEquals(city, point.getCity()); // Проверяем город
        assertEquals(address, point.getLocalAddress()); // Проверяем адрес
    }

    @Test
    void testGetters() {
        String city = "Санкт-Петербург";
        String address = "Невский проспект, 100";
        DeliveryPoint point = new DeliveryPoint(city, address);

        assertEquals(city, point.getCity());
        assertEquals(address, point.getLocalAddress());
        assertNotNull(point.getId()); // Проверяем, что ID не null
    }


    @Test
    void testSetters() {
        DeliveryPoint point = new DeliveryPoint("Москва", "ул. Пушкина, 10");

        String newCity = "Питер";
        String newAddress = "ул. Невского, 1";
        point.setLocalAddress(newAddress);
        point.setCity(newCity);
        assertEquals(newAddress, point.getLocalAddress());
        assertEquals(newCity, point.getCity());

        assertEquals(point.getId(), point.getId());


    }

    @Test
    void testToString() {
        DeliveryPoint point = new DeliveryPoint("Казань", "ул. Баумана, 1");
        String expected = "\nПункт выдачи" +
                "\nГород: Казань'" +
                "\nАдрес: ул. Баумана, 1";
        assertEquals(expected, point.toString());
    }


    @Test
    void testNullCity(){
        assertThrows(NullPointerException.class, () -> new DeliveryPoint(null, "ул. Пушкина, 10"));
    }

    @Test
    void testNullAddress(){
        assertThrows(NullPointerException.class, () -> new DeliveryPoint("Москва", null));
    }

    @Test
    void testEmptyCity(){
        DeliveryPoint point = new DeliveryPoint("", "ул. Пушкина, 10");
        assertEquals("", point.getCity());
    }

    @Test
    void testEmptyAddress(){
        DeliveryPoint point = new DeliveryPoint("Москва", "");
        assertEquals("", point.getLocalAddress());
    }
}