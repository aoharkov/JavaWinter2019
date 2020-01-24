package com.bank.repository.impl;

import com.bank.domain.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.Pageable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<Integer, Account> accountIdToAccount;

    public AccountRepositoryImpl() {
        accountIdToAccount = new HashMap<>();
    }

    @Override
    public Pageable<Account> findAll(int page, int itemsPerPage) {
        long numberOfItemsToSkip = (page - 1) * (long) itemsPerPage;
        int maxPage = (int)((count() + itemsPerPage - 1) / itemsPerPage);
        List<Account> list = accountIdToAccount.values().stream()
                .skip(numberOfItemsToSkip)
                .limit(itemsPerPage)
                .collect(Collectors.toList());
        return PageableImpl.<Account>builder()
                .withItems(list)
                .withPageNumber(page)
                .withItemsNumberPerPage(itemsPerPage)
                .withMaxPage(maxPage)
                .build();
    }

    @Override
    public long count() {
        return accountIdToAccount.size();
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accountIdToAccount.values());
    }

    @Override
    public Optional<Account> findById(Integer id) {
        Account account = accountIdToAccount.getOrDefault(id, null);
        if (account == null) {
            return Optional.empty();
        }
        return Optional.of(account);
    }

    @Override
    public void save(Account entity) {
        accountIdToAccount.put(entity.getId(), entity);
    }

    @Override
    public void update(Account entity) {
        if (accountIdToAccount.containsKey(entity.getId())) {
            accountIdToAccount.put(entity.getId(), entity);
        }
    }

    @Override
    public void deleteById(Integer id) {
        accountIdToAccount.remove(id);
    }
}
