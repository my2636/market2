import entity.DeliveryPoint;
import entity.Item;
import entity.User;
import enums.Category;
import enums.OrderStatus;
import service.*;

import java.util.*;

public class Main {
    static UserService userService = new UserServiceImpl();
    static UserItemServiceImpl userItemServiceImpl = new UserItemServiceImpl();
    static MarketItemServiceImpl marketItemServiceImpl = new MarketItemServiceImpl();
    static OrderService orderService = new OrderServiceImpl();
    static DeliveryPointService deliveryPointService = new DeliveryPointServiceImpl();
    static User user = auth();

    public static void main(String[] args) {

        marketItemServiceImpl.addItems(new Item("Чай зеленый", Category.FOOD, 60.7),
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

            System.out.println("\nВыберите опцию: \n1. Каталог \n2. Корзина \n3. Заказы \n0. Выход\n");
            String input = sc.nextLine();

            switch (input) {
                case "0":
                    System.out.println("Выход из программы");
                    cycle = false;
                    break;

                case "1":
                    while (true) {
                        System.out.println("\nКаталог:");
                        marketItemServiceImpl.showItems();
                        System.out.println("________________________ \n1. Добавить товары в корзину \n0. Назад в меню");
                        String catalogInput = sc.nextLine();

                        if ("0".equals(catalogInput)) {
                            break;

                        } else if ("1".equals(catalogInput)) {
                            System.out.println("\nВведите номера товаров (через пробел): ");
                            try {
                                int[] numbers = getIntArray(sc.nextLine());
                                List<Item> items = marketItemServiceImpl.getListByNumbers(numbers);
                                userItemServiceImpl.addList(items);
                                System.out.println("\nТовары добавлены:");
                                System.out.println(items + "\n");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }

                    break;

                case "2":
                    while (true) {
                        System.out.println("\nКорзина:");
                        userItemServiceImpl.showItems();
                        System.out.println("________________________ \n1. Удалить товары \n2. Сделать заказ \n0. Назад в меню");
                        String userStorageInput = sc.nextLine();
                        if ("0".equals(userStorageInput)) {
                            break;
                        } else if ("1".equals(userStorageInput)) {
                            System.out.println("\nВведите номера товаров (через пробел): ");
                            try {
                                int[] numbers = getIntArray(sc.nextLine());
                                userItemServiceImpl.deleteByNumbers(numbers);
                                System.out.println("\nТовары удалены.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if ("2".equals(userStorageInput)) {
                            System.out.println("\nВведите номера позиций для заказа (через пробел): ");
                            try {
                                int[] numbers = getIntArray(sc.nextLine());
                                List<Item> orderList = userItemServiceImpl.getListByNumbers(numbers);
                                System.out.println("Введите номер пункта доставки: ");
                                deliveryPointService.showList();
                                int pointNumber = Integer.parseInt(sc.nextLine());
                                UUID pointId = deliveryPointService.getByNumber(pointNumber).getId();
                                orderService.createOrder(user.getId(), pointId, orderList);
                                userItemServiceImpl.deleteList(orderList);
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
                        System.out.println("\nЗаказы:");
                        System.out.println(orderService.getOrders());
                        System.out.println("byId:\n");
                        orderService.showOrdersByUserId(user.getId());
                        System.out.println("________________________ \n1. Получить заказ \n2. Отменить заказ \n0. Назад в меню");
                        String catalogInput = sc.nextLine();
                        if ("0".equals(catalogInput)) {
                            break;

                        } else if ("1".equals(catalogInput)) {
                            System.out.println("\nВведите номер заказа: ");
                            try {
                                int orderNumber = Integer.parseInt(sc.nextLine());
                                orderService.getOrderByNumber(orderNumber - 1).setStatus(OrderStatus.COMPLETED);
                                System.out.println("\nЗаказ получен.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if ("2".equals(catalogInput)) {
                            System.out.println("\nВведите номер заказа: ");
                            int orderNumber = Integer.parseInt(sc.nextLine());
                            orderService.getOrderByNumber(orderNumber - 1).setStatus(OrderStatus.CANCELED);
                            System.out.println("\nЗаказ отменен.");
                        }
                    }

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
        return userService.getByNameOrAdd(name);
    }

    public static int[] getIntArray(String input) {
        String[] numbersStr = input.split("[,\\s+]");
        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < numbersStr.length; i++) {
            try {
                numbersList.add(Integer.parseInt(numbersStr[i].trim()));
            } catch (NumberFormatException e) {
                System.err.println("Ввели некорректный номер товара.");
            }
        }
        return numbersList.stream().mapToInt(Integer::intValue).toArray();
    }
}
