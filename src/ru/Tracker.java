package ru;

import java.time.*;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position] = item;
        this.position++;
        return item;
    }

    //вернем конкретное значение
    public Item getItem(int item) {
        return this.items[item];
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * Уникальный ключ нужно генерировать на основании времени и произвольного числа.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        long millis = System.currentTimeMillis() % 1000;
        return Double.toString(Math.random() * 100 + millis);
    }

    /**
     * Метод редактирование заявок - должен заменить ячейку в массиве this.items.
     * Для этого необходимо найти ячейку в массиве по id.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                break;
            }
        }
    }

    /**
     * System.arrayCopy(from, fromIndex, to, toIndex, count);
     *
     * @param id
     */
    public void delete(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                this.position--;
                break;
            }
        }
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод public Item[] findByName(String key) провер все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
     */
    public Item[] findByName(String key) {
        Item[]  ret = new Item[position];
        int a = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getName() != null && this.items[i].getName().equals(key)) {
                ret[a++] = items[i];
            }
        }
        return Arrays.copyOf(ret, a);
    }

    /**
     * Метод public Item findById(String id) проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     */
    public Item findById(String id) {
        int a = -1;
        Item ret = this.items[0];
        for (int i = 0; i < this.findAll().length; i++) {
            if (this.items[i].getId().equals(id)) {
                a = i;
                System.out.println("catch");
                ret = this.items[a];
                break;
            }
        }
        if (a > 0) {
            return ret;
        } else {
            return null;
        }
    }
}
