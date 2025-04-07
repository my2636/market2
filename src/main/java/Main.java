import entity.DeliveryPoint;
import entity.Item;
import enums.Category;
import service.*;

public class Main {
    public static void main(String[] args) {
        MarketItemService marketItemService = new MarketItemService();
        UserItemService userItemService = new UserItemService();
        OrderService orderService = new OrderServiceImpl();
        DeliveryPointService deliveryPointService = new DeliveryPointServiceImpl();

        marketItemService.addItems(new Item("Чай зеленый", Category.FOOD, 60.7),
                new Item("Плед мягкий пушистый", Category.HOME, 260.5),
                new Item("Кот домашний", Category.HOME, 5000),
                new Item("Плащ демисезонный", Category.CLOTHES, 4000),
                new Item("Термочашка с двойными стенками", Category.HOME, 180.7)

        );

        deliveryPointService.addDeliveryPoints(new DeliveryPoint("Санкт-Петербург", "ул. Калинникова, 8"),
                new DeliveryPoint("Санкт-Петербург", "ул. Кирпичная, 164"),
                new DeliveryPoint("Санкт-Петербург", "ул. Зайцева, 43a"),
                new DeliveryPoint("Санкт-Петербург", "ул. Запрудная, 201")

        );

        marketItemService.showItems();
        System.out.println("__________");
        deliveryPointService.showItems();


    }
}
