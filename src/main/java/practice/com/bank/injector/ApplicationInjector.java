package practice.com.bank.injector;

import practice.com.bank.domain.User;
import practice.com.bank.repository.UserRepository;
import practice.com.bank.repository.impl.UserRepositoryImpl;
import practice.com.bank.service.PasswordEncoder;
import practice.com.bank.service.UserService;
import practice.com.bank.service.impl.UserServiceImpl;
import practice.com.bank.service.validator.UserValidator;
import practice.com.bank.service.validator.Validator;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncoder PASSWORD_ENCRIPTOR = new PasswordEncoder();

    private static final UserRepository USER_REPOSITORY = new UserRepositoryImpl();

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
