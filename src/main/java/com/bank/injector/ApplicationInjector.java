package com.bank.injector;

import com.bank.dao.UserDao;
import com.bank.dao.impl.UserDaoImpl;
import com.bank.dao.util.ConnectorToDB;
import com.bank.entity.User;
import com.bank.service.passwordencoder.PasswordEncoder;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;
import com.bank.service.passwordencoder.PasswordEncoderPBKDF2Impl;
import com.bank.service.validator.UserValidator;
import com.bank.service.validator.Validator;
import com.bank.view.ApplicationView;

import java.util.Scanner;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncoder PASSWORD_ENCODER = new PasswordEncoderPBKDF2Impl();

    private static final ConnectorToDB CONNECTOR = new ConnectorToDB("database");

    private static final UserDao USER_DAO = new UserDaoImpl(CONNECTOR);

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_DAO, PASSWORD_ENCODER, USER_VALIDATOR);

    private static final ApplicationView APPLICATION_VIEW = new ApplicationView(new Scanner((System.in)));

    private ApplicationInjector() {

    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }

    public static UserDao getUserDao() {
        return USER_DAO;
    }

    public static ApplicationView getApplicationView() {
        return APPLICATION_VIEW;
    }
}
