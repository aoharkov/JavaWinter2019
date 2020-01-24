package com.bank.repository.impl;

import com.bank.domain.User;
import com.bank.repository.Pageable;
import com.bank.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Integer, User> userIdToUser = new HashMap<>();

    @Override
    public Pageable<User> findAll(int page, int itemsPerPage) {
        long numberOfItemsToSkip = (page - 1) * (long) itemsPerPage;
        int maxPage = (int) ((count() + itemsPerPage - 1) / itemsPerPage);
        List<User> list = userIdToUser.values().stream()
                .skip(numberOfItemsToSkip)
                .limit(itemsPerPage)
                .collect(Collectors.toList());
        return PageableImpl.<User>builder()
                .withItems(list)
                .withPageNumber(page)
                .withItemsNumberPerPage(itemsPerPage)
                .withMaxPage(maxPage)
                .build();
    }

    @Override
    public long count() {
        return userIdToUser.size();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userIdToUser.values());
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
    public Optional<User> findByEmail(String email) {
        //TODO: add validation
        return userIdToUser.values().stream()
                .filter((User user) -> user.getEmail().equals(email))
                .findAny();
    }

    @Override
    public void save(User entity) {
        userIdToUser.put(entity.getId(), entity);
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
