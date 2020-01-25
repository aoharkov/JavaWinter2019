package com.bank.dao.impl;

import com.bank.dao.util.ConnectorToDB;
import com.bank.dao.util.PageableImpl;
import com.bank.domain.Account;
import com.bank.dao.AccountDao;
import com.bank.dao.util.Pageable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountDaoImpl extends AbstractCrudPageableDaoImpl<Account> implements AccountDao{
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
