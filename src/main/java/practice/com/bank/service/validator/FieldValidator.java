package practice.com.bank.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator {

    public static void validateId(Integer id) throws ValidatorException {
        if (id < 1) {
            throw new ValidatorException("id is not positive");
        }
    }

    public static void validateEmail(String email) throws ValidatorException {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new ValidatorException("email is not positive");
        }
    }

    public static void validatePassword(String password) throws ValidatorException {
        if (password.length() < 8) {
            throw new ValidatorException("password is shorter than 8 symbols");
        }
    }
}
