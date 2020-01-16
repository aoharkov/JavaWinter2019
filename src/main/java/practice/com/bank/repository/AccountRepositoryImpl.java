package practice.com.bank.repository;

import practice.com.bank.domain.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<Integer, Account> accountIdToAccount = new HashMap<>();
    @Override
    public void save(Account entity) {

    }

    @Override
    public Account findById(Integer id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public void update(Account entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
