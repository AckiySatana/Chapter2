package ru;
public class StartUI {
    private static final String ADD = "0"; // Константа меню для добавления новой заявки.
    private static final String SHOWALL = "1"; // Константа показать все записи
    private static final String EDIT = "2"; // Константа редактировать запись
    private static final String DELETE = "3"; // Константа для удаления записи
    private static final String FINDBYID = "4"; // Константа для поиска записи по id
    private static final String FINDBYNAME = "5"; // Константа для поиска записи по имени
    private static final String EXIT = "6"; // Константа для выхода из цикла.
    private final Input input; // Получение данных от пользователя.
    private final Tracker tracker; // Хранилище заявок.

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
//добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            }
            else if (EDIT.equals(answer)) {
                this.editItem();
            }
            else if (FINDBYID.equals(answer)) {
                this.findByIdItem();
            }
            else if (FINDBYNAME.equals(answer)) {
                this.findByNameItem();
            }
            else if (SHOWALL.equals(answer)) {
                this.showAllItem();
            }
            else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void showAllItem() {
        System.out.println("------------ Поиск всех записей --------------");
        String key = this.input.ask("Введите Наименование заявки для поиска:");
        Item[] findit=tracker.findAll();
        System.out.println("------------ Найдено"+(findit.length+1) +" Записей--------------");

    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки для удаления:");
        tracker.delete(id);
        System.out.println("------------ Была запись, и нет записи --------------");
    }
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки для редактирования:");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
        System.out.println("------------ Запись отредактирована --------------");
    }

    private void findByNameItem() {
        System.out.println("------------ Удаление заявки --------------");
        String key = this.input.ask("Введите Наименование заявки для поиска:");
        Item[] findit=tracker.findByName(key);
        System.out.println("------------ Найдено"+(findit.length+1) +" Записей--------------");

    }

    private void findByIdItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки для поиска:");
        Item findit=tracker.findById(id);
        if (findit!=null) {
            System.out.println("------------ нет записи с указанным id --------------");
        } else {
            System.out.println("------------ Найдена запись с id "+ id +" --------------");
            System.out.println("------------ Наименование "+ findit.getName() +" --------------");
        }
    }
    private void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}