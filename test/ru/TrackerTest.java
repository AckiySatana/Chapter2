package ru;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    /**
     * проверка псоздания м привязки новой записи
     * генерпции id и проверка заполнения всякого.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getItem(0), is(item));
    }

    /**
     * Проверка перемещения + проверка получения полного списка
     * Проверим сначала замену, далее получение полного списка заявок (чтобы получить корректное значение)
     * далее удаление (число заявок должно уменьшиться на 1)
     */
    @Test
    public void whenReplaceTHenAllCool() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test2", "testDescription", 123L);
        tracker.add(item1);

        Item item2 = new Item("test2", "testDescription", 123L);
        tracker.add(item2);

        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item3);

        tracker.replace(item1.getId(), item3);
        assertThat(tracker.getItem(0), is(item3));

        assertThat(tracker.findAll().length, is(3));
    }

    @Test
    public void whenGetCount() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test2", "testDescription", 123L);
        tracker.add(item1);

        Item item2 = new Item("test2", "testDescription", 123L);
        tracker.add(item2);

        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item3);

        assertThat(tracker.findAll().length, is(3));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test2", "testDescription", 123L);
        tracker.add(item1);

        Item item2 = new Item("test2", "testDescription", 123L);
        tracker.add(item2);

        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item3);

        tracker.delete(item2.getId());

        assertThat(tracker.findAll().length, is(2));
    }

    @Test
    public void whenFindName() {
        Tracker tracker = new Tracker();

        Item item1 = new Item("test2", "testDescription", 123L);
        tracker.add(item1);
        System.out.println(item1.getName());

        Item item2 = new Item("test2", "testDescription", 123L);
        tracker.add(item2);

        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item3);

        Item[] it = tracker.findByName("test2");

        assertThat(it.length, is(2));
        assertThat(it[0].getId(),is(item1.getId()));
        assertThat(it[1].getId(),is(item2.getId()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();

        Item item1 = new Item("test2", "testDescription", 123L);
        tracker.add(item1);
        System.out.println(item1.getName());

        Item item2 = new Item("test2", "testDescription", 123L);
        tracker.add(item2);

        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item3);

        assertThat(tracker.findById(item1.getId()),is(item1));
    }

}

