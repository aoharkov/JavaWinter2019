package com.bank.dao.impl;

import com.bank.dao.AccountDao;
import com.bank.dao.util.ConnectorToDB;
import com.bank.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl extends AbstractCrudPageableDaoImpl<Account> implements AccountDao {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM accounts WHERE id =?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM accounts";

    public AccountDaoImpl(ConnectorToDB connector) {
        super(connector, FIND_BY_ID_QUERY, FIND_ALL_QUERY);
    }

    protected Account mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return Account.builder()
                .withId(resultSet.getInt("id"))
                .withMoney(resultSet.getInt("money"))
                .build();
    }
}
