package practice.com.bank.service.validator;

public interface Validator<E> {
    void validate(E entity) throws ValidatorException;
}
