package practice.com.bank.service.validator;

import practice.com.bank.domain.User;

public class UserValidator implements Validator<User> {
    @Override
    public void validate(User entity) {
        //use reg ex
        //in this case throw exception
    }
}
