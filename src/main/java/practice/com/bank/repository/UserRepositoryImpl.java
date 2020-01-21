package practice.com.bank.repository;

import practice.com.bank.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository{
    private final Map<Integer, User> userIdToUser = new HashMap<>();

    @Override
    public Optional<User> findByEmail(String email) {
        for (User user : userIdToUser.values()) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(User entity) {
        userIdToUser.put(entity.getId(), entity);
    }

    @Override
    public Optional<User> findById(Integer id) {
        User user = userIdToUser.getOrDefault(id, null);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userIdToUser.values());
    }

    @Override
    public void update(User entity) {
        if (userIdToUser.containsKey(entity.getId())) {
            userIdToUser.put(entity.getId(), entity);
        }
    }

    @Override
    public void deleteById(Integer id) {
        userIdToUser.remove(id);
    }
}
