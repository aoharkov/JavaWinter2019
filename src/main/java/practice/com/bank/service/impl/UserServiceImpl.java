package practice.com.bank.service.impl;


import practice.com.bank.domain.User;
import practice.com.bank.repository.UserRepository;
import practice.com.bank.service.PasswordEncoder;
import practice.com.bank.service.UserService;
import practice.com.bank.service.validator.Validator;
import practice.com.bank.service.validator.ValidateException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final int USER_PER_PAGE = 5;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncryptor;
    private final Validator<User> userValidator;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncryptor, Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncryptor = passwordEncryptor;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        //login validate with email and password
        String encryptedPassword = passwordEncryptor.encrypt(password);
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword())
                .filter(userPass -> userPass.equals(encryptedPassword))
                .isPresent();
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("user is already present with such email");
        }
        userRepository.save(user);

        //id?
        return user;
    }

    //TODO
    @Override
    public List<User> findAll() {
        //page should be validate -> if not valide put 1
        // if page > last  page = last
        //final Pageable<User> users = userRepository.findAll(new Page(page, USER_PER_PAGE));
        return null;
    }


}
