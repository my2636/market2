import entity.DeliveryPoint;
import entity.Item;
import entity.User;
import enums.Category;
import enums.OrderStatus;
import service.*;

import java.util.UUID;
import java.util.List;
import java.util.Scanner;

public class Main {
    static User user = auth();
    static UserService userService = new UserServiceImpl();
    static UserItemService userItemService = new UserItemService();
    static MarketItemService marketItemService = new MarketItemService();
    static OrderService orderService = new OrderServiceImpl();
    static DeliveryPointService deliveryPointService = new DeliveryPointServiceImpl();

    public static void main(String[] args) {

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

        options();

    }

    public static void options() {
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
                            try {
                                int[] numbers = getIntArray(sc.nextLine());
                                List<Item> orderList = userItemService.getListByNumbers(numbers);
                                System.out.println("Введите номер пункта доставки: ");
                                deliveryPointService.showList();
                                int pointNumber = Integer.parseInt(sc.nextLine());
                                UUID pointId = deliveryPointService.getByNumber(pointNumber).getId();
                                orderService.createOrder(user.getId(), pointId, orderList);
                                System.out.println("\nЗаказ создан.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Нет такой опции.");
                        }
                    }

                    break;

                case "3":
                    while (true) {
                        orderService.showOrdersByUserId(user.getId());
                        System.out.println("________________________ \n1. Получить заказ \n2. Отменить заказ \n0. Назад в меню");
                        String catalogInput = sc.nextLine();
                        if ("0".equals(catalogInput)) {
                            break;

                        } else if ("1".equals(catalogInput)) {
                            System.out.println("\nВведите номер заказа: ");
                            try {
                                int orderNumber = Integer.parseInt(sc.nextLine());
                                orderService.getOrderByNumber(orderNumber).setStatus(OrderStatus.COMPLETED);
                                System.out.println("\nЗаказ получен.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if ("2".equals(catalogInput)) {
                            int orderNumber = Integer.parseInt(sc.nextLine());
                            orderService.getOrderByNumber(orderNumber).setStatus(OrderStatus.CANCELED);
                        }
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

    public static User auth() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Напишите Ваше имя: ");
        String name = sc.nextLine();
        User user = userService.getByName(name);

        if (user != null) {
            return user;
        } else {
            User newUser = new User(name);
            userService.add(newUser);
            return newUser;
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
