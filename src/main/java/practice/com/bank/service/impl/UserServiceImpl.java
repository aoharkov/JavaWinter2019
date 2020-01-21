package practice.com.bank.service.impl;


import practice.com.bank.domain.User;
import practice.com.bank.repository.UserRepository;
import practice.com.bank.service.PasswordEncriptor;
import practice.com.bank.service.UserService;
import practice.com.bank.service.validator.UserValidator;
import practice.com.bank.service.validator.Validator;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncriptor passwordEncriptor;
    private final Validator<User> userValidator;


    public UserServiceImpl(UserRepository userRepository, PasswordEncriptor passwordEncriptor, Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncriptor = passwordEncriptor;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        //final Optional<User> user = userRepository.findByEmail(email);
        //userRepository.findByEmail(email).map(x -> x.getPassword()).orElse(null);
        /*String userPassword = userRepository.findByEmail(email)
                .map(user -> user.getPassword())
                .filter(userPass -> userPass.equals(password))
                .orElse(null);

        return userPassword != null;*/
        String encriptedPassword = passwordEncriptor.encript(password);
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword())
                .filter(userPass -> userPass.equals(encriptedPassword))
                .isPresent();
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);
        return null;
    }


}
