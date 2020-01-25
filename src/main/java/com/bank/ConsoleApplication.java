package com.bank;

import com.bank.injector.ApplicationInjector;
import com.bank.service.UserService;

public class ConsoleApplication {
    public static void main(String[] args) {
        UserService userService = ApplicationInjector.getUserService();
        final boolean password = userService.login("email", "pass");
        System.out.println(password);
    }
}
