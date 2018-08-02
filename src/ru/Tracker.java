package ru;

import java.time.*;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

//Item item = new Item("test1","testDescription",123L);
// привязка заявки к трекеру

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
        Item[] it = new Item[this.items.length];
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                if (i - 1 >= 0) {
                    System.arraycopy(this.items, 0, this.items, 0, i);
                }
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                break;
            }
        }
    }

    public Item[] findAll() {
        int a;
        Item[] it;
        for (a = 0; a < this.items.length; a++) {
            if (this.items[a] == null) {
                break;
            }
        }
        it = new Item[a];
        System.arraycopy(this.items, 0, it, 0, a);
        return it;
    }

    /**
     * Метод public Item[] findByName(String key) провер все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
     */
    public Item[] findByName(String key) {
        Item[] all, ret = new Item[100];
        int a = 0;
        for (int i = 0; i < this.findAll().length; i++) {
            if (this.items[i].getName() != null && this.items[i].getName().equals(key)) {
                System.arraycopy(this.items, i, ret, a, 1);
                a++;
            }
        }
        all = new Item[a];
        System.arraycopy(ret, 0, all, 0, a);
        return all;
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
