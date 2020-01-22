package practice.com.bank.service.validator;

import practice.com.bank.domain.User;

public class UserValidator implements Validator<User> {

    @Override
    public void validate(User entity) throws ValidatorException {
        try {
            FieldValidator.validateId(entity.getId());
            FieldValidator.validateEmail(entity.getEmail());
            FieldValidator.validatePassword(entity.getPassword());
        }catch (ValidatorException e) {
            throw new ValidatorException("User is not valid: " + e.getMessage());
        }

    }

}
