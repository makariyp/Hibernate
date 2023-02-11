package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Makar", "Petrov", (byte) 23);
        System.out.println("User с именем – Makar добавлен в базу данных");
        userService.saveUser("Aleksandra", "Petrova", (byte) 21);
        System.out.println("User с именем – Aleksandra добавлен в базу данных");
        userService.saveUser("Egor", "Kogor", (byte) 23);
        System.out.println("User с именем – Egor добавлен в базу данных");
        userService.saveUser("Misha", "Solovyov", (byte) 21);
        System.out.println("User с именем – Misha добавлен в базу данных");
        List<User> users = userService.getAllUsers();
        System.out.println("Вывод пользователей на экран:");
        users.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
