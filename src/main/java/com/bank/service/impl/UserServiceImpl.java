package com.bank.service.impl;

import com.bank.dao.UserDao;
import com.bank.entity.User;
import com.bank.service.PasswordEncoder;
import com.bank.service.UserService;
import com.bank.service.validator.Validator;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncryptor;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncryptor, Validator<User> userValidator) {
        this.userDao = userDao;
        this.passwordEncryptor = passwordEncryptor;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        //login validate with email and password
        String encryptedPassword = passwordEncryptor.encrypt(password);
        return userDao.findByEmail(email)
                .map(user -> user.getPassword())
                .filter(userPass -> userPass.equals(encryptedPassword))
                .isPresent();
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);
        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("user is already present with such email");
        }
        userDao.save(user);
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
