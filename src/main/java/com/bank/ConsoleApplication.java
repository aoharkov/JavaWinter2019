package com.bank;

import com.bank.controller.ApplicationController;
import com.bank.dao.UserDao;
import com.bank.entity.User;
import com.bank.injector.ApplicationInjector;
import com.bank.service.UserService;
import com.bank.view.ApplicationMessenger;
import com.bank.view.ApplicationView;

public class ConsoleApplication {
    public static void main(String[] args) {
        UserService userService = ApplicationInjector.getUserService();
        User user = User.builder()
                .withId(1)
                .withEmail("test@gmail.com")
                .withPassword("12341234")
                .build();
        userService.register(user);
        UserDao userDao = ApplicationInjector.getUserDao();
        ApplicationView applicationView = ApplicationInjector.getApplicationView();
        new ApplicationController(userDao, applicationView, new ApplicationMessenger()).run();
    }
}
