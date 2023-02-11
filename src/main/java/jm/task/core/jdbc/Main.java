package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userDao = new UserServiceImpl();
        userDao.createUsersTable();
        userDao.saveUser("Makar", "Petrov", (byte) 23);
        System.out.println("User с именем – Makar добавлен в базу данных");
        userDao.saveUser("Aleksandra", "Petrova", (byte) 21);
        System.out.println("User с именем – Aleksandra добавлен в базу данных");
        userDao.saveUser("Egor", "Kogor", (byte) 23);
        System.out.println("User с именем – Egor добавлен в базу данных");
        userDao.saveUser("Misha", "Solovyov", (byte) 21);
        System.out.println("User с именем – Misha добавлен в базу данных");
        List<User> users = userDao.getAllUsers();
        users.forEach(System.out::println);
    }
}
