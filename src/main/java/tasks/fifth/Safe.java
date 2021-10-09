package tasks.fifth;

import java.util.ArrayList;

/**
 * Есть набор предметов, задаваемый заранее, предметы могут повторяться.
 * Предмет имеет 2 параметра (обязательных, остальные добавлять на усмотрение): объем (целое значение) и ценность (целое значение).
 * Предметы неделимы. Также задаётся сейф с обязательным параметром его объёма (целое значение).
 * Нужно написать программу, которая наполняет сейф набором предметов таким образом, чтобы ценность этого набора была максимальной.
 */

public class Safe {
    private ArrayList<Item> bestItems = null;

    private final int maxCapacity;

    private int bestPrice;

    public Safe(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    //создание всех наборов перестановок значений
    public void makeAllSets(ArrayList<Item> items) {
        if (items.size() > 0)
            checkSet(items);

        for (int currentItem = 0; currentItem < items.size(); currentItem++) {
            ArrayList<Item> newSet = new ArrayList<>(items);
            newSet.remove(currentItem);
            makeAllSets(newSet);
        }

    }

    //проверка, является ли данный набор лучшим решением задачи
    private void checkSet(ArrayList<Item> items) {
        if (bestItems == null) {
            if (calculateCapacity(items) <= maxCapacity) {
                bestItems = items;
                bestPrice = calculatePrice(items);
            }
        }
        else {
            if(calculateCapacity(items) <= maxCapacity && calculatePrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = calculatePrice(items);
            }
        }
    }

    //вычисляет общий вес набора предметов
    private int calculateCapacity(ArrayList<Item> items) {
        int sumCapacity = 0;
        for (Item i : items) {
            sumCapacity += i.getCapacity();
        }
        return sumCapacity;
    }

    //вычисляет общую стоимость набора предметов
    private int calculatePrice(ArrayList<Item> items) {
        int sumPrice = 0;
        for (Item i : items) {
            sumPrice += i.getPrice();
        }
        return sumPrice;
    }

    //возвращает решение задачи (набор предметов)
    public ArrayList<Item> getBestSet() {
        return bestItems;
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Книга", 1, 700));
        items.add(new Item("Кольцо", 2, 5500));
        items.add(new Item("Клавиатура", 4, 1500));
        items.add(new Item("Ноутбук", 7, 40000));
        items.add(new Item("Ручка", 1, 100));

        Safe safe = new Safe(10);
        safe.makeAllSets(items);
        System.out.println(safe.getBestSet());
    }
}
