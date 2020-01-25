package com.bank.injector;

import com.bank.dao.UserDao;
import com.bank.dao.impl.UserDaoImpl;
import com.bank.dao.util.ConnectorToDB;
import com.bank.domain.User;
import com.bank.service.PasswordEncoder;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;
import com.bank.service.validator.UserValidator;
import com.bank.service.validator.Validator;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncoder PASSWORD_ENCRIPTOR = new PasswordEncoder();

    private static final ConnectorToDB CONNECTOR = new ConnectorToDB("database");

    private static final UserDao USER_REPOSITORY = new UserDaoImpl(CONNECTOR);

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRIPTOR, USER_VALIDATOR);

    private ApplicationInjector() {

    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }
}
