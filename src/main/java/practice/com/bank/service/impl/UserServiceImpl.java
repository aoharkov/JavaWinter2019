package practice.com.bank.service.impl;


import practice.com.bank.domain.User;
import practice.com.bank.repository.UserRepository;
import practice.com.bank.service.PasswordEncryptor;
import practice.com.bank.service.UserService;
import practice.com.bank.service.validator.Validator;
import practice.com.bank.service.validator.ValidatorException;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncryptor passwordEncryptor;
    private final Validator<User> userValidator;


    public UserServiceImpl(UserRepository userRepository, PasswordEncryptor passwordEncryptor, Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncryptor = passwordEncryptor;
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
        String encriptedPassword = passwordEncryptor.encript(password);
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword())
                .filter(userPass -> userPass.equals(encriptedPassword))
                .isPresent();
    }

    @Override
    public User register(User user) {
        try {
            userValidator.validate(user);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return user;
    }


}
