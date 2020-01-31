package com.bank.controller;

import com.bank.dao.UserDao;
import com.bank.view.ApplicationMessenger;
import com.bank.view.ApplicationView;

public class ApplicationController {
    private final UserDao userDao;
    private final ApplicationView view;
    private final ApplicationMessenger messenger;

    public ApplicationController(UserDao userDao, ApplicationView view, ApplicationMessenger messenger) {
        this.userDao = userDao;
        this.view = view;
        this.messenger = messenger;
    }

    public void run() {
        int command = -1;
        while (command != 0) {
            view.printMessage(messenger.getMessage("inputChooseMessage"));
            command = view.readIntValue();
            switch (command) {
                case 1:
                    findUserById();
                    break;
                case 2:
                    findUserByEmail();
                    break;
                default:
                    view.printMessage(messenger.getMessage("unknownCommandMessage"));
            }
        }
    }

    private void findUserById() {
        view.printMessage(messenger.getMessage("enterIdMessage"));
        Integer id = view.readIntValue();
        userDao.findById(id).ifPresent(view::printMessage);
    }

    private void findUserByEmail() {
        view.printMessage(messenger.getMessage("enterEmailMessage"));
        String email = view.readStringValue();
        userDao.findByEmail(email).ifPresent(view::printMessage);
    }
}
