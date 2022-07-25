package org.peaksoft;

import org.peaksoft.model.User;
import org.peaksoft.service.UserService;
import org.peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService  = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Almaz", "Atambaev", (byte) 25);
        userService.saveUser("Kurmanbek", "Bakiev", (byte) 30);
        userService.saveUser("Askar", "Akaev", (byte) 30);
        for (User u :userService.getAllUsers()) {
            System.out.println(u);
        }
        System.out.println("----------------------------");
        userService.removeUserById(1);
        for (User u :userService.getAllUsers()) {
            System.out.println(u);
        }
        System.out.println("----------------------------");
        userService.cleanUsersTable();
        for (User u :userService.getAllUsers()) {
            System.out.println(u);
        }

    }
}