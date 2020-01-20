package practice.com.bank.repository;

import practice.com.bank.domain.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<Integer, Account> accountIdToAccount;

    public AccountRepositoryImpl() {
        accountIdToAccount = new HashMap<>();
    }

    @Override
    public void save(Account entity) {
        accountIdToAccount.put(entity.getId(), entity);
    }

    @Override
    public Account findById(Integer id) {
        return accountIdToAccount.getOrDefault(id, null);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accountIdToAccount.values());
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
