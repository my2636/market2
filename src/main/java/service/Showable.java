package service;

import java.util.List;


public interface Showable<T> {
    default void showList(List<T> showList) {
        if (showList.isEmpty()) {
            System.out.println("Список пуст");
        }
        int index = 1;
        for (T t : showList) {
            System.out.println("\n" + index++ + ". " + t.toString());
        }
    }

    /**
     * Метод для смещения начала нумерации с 0 на 1
     */
    /*
    Магические числа - вместо System.out.println("\n" + (showList.indexOf(t) + 1) + ". " + t.toString())
    использовала индекс
    */
}
