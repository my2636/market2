import entity.DeliveryPoint;
import entity.Item;
import enums.Category;
import service.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

        options(marketItemService, userItemService,
                orderService, deliveryPointService);

    }

    public static void options(MarketItemService marketItemService, UserItemService userItemService,
                               OrderService orderService, DeliveryPointService deliveryPointService) {
        boolean cycle = true;
        while (cycle) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nВыберите опцию: \n1. Каталог \n2. Корзина \n3. Заказы \n4. Выход");
            String input = sc.nextLine();

            switch (input) {
                case "1":
                    while (true) {
                        marketItemService.showItems();
                        System.out.println("________________________ \n1. Добавить товары в корзину \n0. Назад в меню");
                        String catalogInput = sc.nextLine();

                        if ("0".equals(catalogInput)) {
                            break;

                        } else if ("1".equals(catalogInput)) {
                            System.out.println("\nВведите номера товаров: ");
                            try {
                                int[] numbers = getIntArray(sc.nextLine());
                                List<Item> items = marketItemService.getListByNumbers(numbers);
                                System.out.println(items);
                                userItemService.addList(items);
                                System.out.println("\nТовары добавлены.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }

                    break;

                case "2":
                    while (true) {
                        userItemService.showItems();
                        System.out.println("________________________ \n1. Удалить товары \n2. Сделать заказ \n0. Назад в меню");
                        String userStorageInput = sc.nextLine();
                        if ("0".equals(userStorageInput)) {
                            break;
                        } else if ("1".equals(userStorageInput)) {
                            System.out.println("\nВведите номера товаров: ");
                            try {
                                int[] numbers = getIntArray(sc.nextLine());
                                userItemService.deleteByNumbers(numbers);
                                System.out.println("\nТовары удалены.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if ("2".equals(userStorageInput)) {
                            System.out.println("\nВведите номера позиций для заказа: ");
                        } else {
                            System.out.println("Нет такой опции.");
                        }
                    }

                    break;

                case "3":
                    String orderInput = sc.nextLine();
                    while (!"0".equals(orderInput)) {
                        System.out.println("________________________ \n1. Проверить статус заказа \n2. Получить заказ \n3. Отменить заказ \n0. Назад в меню");

                    }
                    break;

                case "4":
                    cycle = false;
                    break;

                default:
                    System.out.println("Такой опции нет");
            }
        }

    }

    public static int[] getIntArray(String input) {
        String[] numbersStr = input.split("[\\s,+]");
        int[] numbersInt = new int[numbersStr.length];

        for (int i = 0; i < numbersStr.length; i++) {
            try {
                numbersInt[i] = Integer.parseInt(numbersStr[i]);
            } catch (NumberFormatException e) {
                System.err.println("Ввели некорректный номер товара.");
            }
        }
        return numbersInt;
    }
}
