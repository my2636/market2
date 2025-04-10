import entity.DeliveryPoint;
import entity.Item;
import entity.Order;
import entity.User;
import enums.Category;
import enums.OrderStatus;
import service.*;

import java.util.*;


public class Main {
    static final UserService userService = new UserServiceImpl();
    static final ItemService userItemServiceImpl = new ItemServiceImpl();
    static final ItemService marketItemServiceImpl = new ItemServiceImpl();
    static final OrderService orderService = new OrderServiceImpl();
    static final DeliveryPointService deliveryPointService = new DeliveryPointServiceImpl();

    public static void main(String[] args) {
        User user = auth();
        if (user == null) {
            System.err.println("Ошибка авторизации!");
            return;
        }

        List<Item> newItems = new ArrayList<>();
        newItems.add(new Item("Чай зеленый", Category.FOOD, 60.7));
        newItems.add(new Item("Плед мягкий пушистый", Category.HOME, 260.5));
        newItems.add(new Item("Кот домашний", Category.HOME, 5000));
        newItems.add(new Item("Плащ демисезонный", Category.CLOTHES, 4000));
        newItems.add(new Item("Термочашка с двойными стенками", Category.HOME, 180.7));

        marketItemServiceImpl.addList(newItems);

        deliveryPointService.addDeliveryPoints(new DeliveryPoint("Санкт-Петербург", "ул. Калинникова, 8"),
                new DeliveryPoint("Санкт-Петербург", "ул. Кирпичная, 164"),
                new DeliveryPoint("Санкт-Петербург", "ул. Зайцева, 43a"),
                new DeliveryPoint("Санкт-Петербург", "ул. Запрудная, 201")

        );

        options(user);
    }

    public static void options(User user) {
        boolean cycle = true;
        String menu1 = "\n1. Каталог";
        String menu2 = "\n2. Корзина";
        String menu3 = "\n3. Заказы";
        String menu0 = "\n0. Выход\n";

        try (Scanner sc = new Scanner(System.in)) {
            while (cycle) {

                System.out.printf("\nВыберите опцию: \n%s%s%s%s", menu1, menu2, menu3, menu0);
                String input = sc.nextLine();
                //DRY - вынесла одинаковые участки кода из кейсов в метод handleCatalog
                switch (input) {
                    case "0":
                        System.out.println("Выход из программы");
                        cycle = false;
                        break;

                    case "1":
                        String caseMenu = "________________________ \n1. Добавить товары в корзину \n0. Назад в меню";
                        List<Item> showList = marketItemServiceImpl.getList();
                        handleCatalog(sc, user, marketItemServiceImpl, menu1, caseMenu, showList);
                        break;

                    case "2":
                        String caseMenu2 = "________________________ \n1. Удалить товары \n2. Сделать заказ \n0. Назад в меню";
                        List<Item> showList2 = userItemServiceImpl.getList();
                        handleCatalog(sc, user, userItemServiceImpl, menu2, caseMenu2, showList2);
                        break;

                    case "3":
                        String caseMenu3 = "________________________ \n1. Получить заказ \n2. Отменить заказ \n0. Назад в меню";
                        List<Order> showList3 = orderService.getList();
                        handleCatalog(sc, user, orderService, menu3, caseMenu3, showList3);
                        break;

                    default:
                        System.out.println("Такой опции нет");
                }
            }
        }
    }

    private static <T> void handleCatalog(Scanner sc,
                                          User user,
                                          Showable<T> showable,
                                          String header,
                                          String caseMenu,
                                          List<T> showlist) {

        while (true) {
            System.out.println(header);
            showable.showList(showlist);
            System.out.println(caseMenu);
            String catalogInput = sc.nextLine();
            if ("0".equals(catalogInput)) {
                break;
            }

            switch (catalogInput) {
                case "1":
                    if (header.equals("\n1. Каталог")) {
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
                    } else if (header.equals("\n2. Корзина")) {
                        System.out.println("\nВведите номера товаров (через пробел): ");
                        try {
                            int[] numbers = getIntArray(sc.nextLine());
                            userItemServiceImpl.deleteByNumbers(numbers);
                            System.out.println("\nТовары удалены.");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (header.equals("\n3. Заказы")) {
                        System.out.println("\nВведите номер заказа: ");
                        try {
                            int orderNumber = Integer.parseInt(sc.nextLine());
                            orderService.getOrderByNumber(orderNumber - 1).setStatus(OrderStatus.COMPLETED);
                            System.out.println("\nЗаказ получен.");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Нет такой опции.");
                    }
                    break;

                case "2":
                    if (header.equals("\n2. Корзина")) {
                        System.out.println("\nВведите номера позиций для заказа (через пробел): ");
                        try {
                            int[] numbers = getIntArray(sc.nextLine());
                            List<Item> orderList = userItemServiceImpl.getListByNumbers(numbers);

                            System.out.println("Введите номер пункта доставки: ");
                            deliveryPointService.showList(deliveryPointService.getList());
                            int pointNumber = Integer.parseInt(sc.nextLine());
                            UUID pointId = deliveryPointService.getByNumber(pointNumber).getId();
                            orderService.createOrder(user.getId(), pointId, orderList);
                            userItemServiceImpl.deleteList(orderList);
                            System.out.println("\nЗаказ создан.");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (header.equals("\n3. Заказы")) {

                        System.out.println("\nВведите номер заказа: ");
                        int orderNumber = Integer.parseInt(sc.nextLine());
                        orderService.getOrderByNumber(orderNumber - 1).setStatus(OrderStatus.CANCELED);
                        System.out.println("\nЗаказ отменен.");
                    } else {
                        System.out.println("Такой опции нет.");
                    }

                    break;

                default:
                    System.out.println("Такой опции нет.");
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
