package service;

import java.util.List;


public interface Showable<T> {
    default void showList(List<T> showList) {
        if (showList.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (T t : showList) {
            System.out.println("\n" + Showable.getShowNumerationIndex(showList.indexOf(t)) + ". " + t.toString());
        }
    }

    /**
     * Метод для смещения начала нумерации с 0 на 1
     */
    //Магические числа - вместо использования ++i или i + 1 в основном коде сделала метод.
    static int getShowNumerationIndex(int i) {
        return ++i;
    }
}
