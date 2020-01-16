package practice.com.bank.repository;

import practice.com.bank.domain.User;

public interface UserRepository extends CrudRepository<User> {
    User findByEmail(String email);
}
