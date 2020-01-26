package com.bank.dao.impl;

import com.bank.dao.AccountDao;
import com.bank.dao.UserDao;
import com.bank.dao.util.ConnectorToDB;
import com.bank.domain.Account;
import com.bank.domain.User;
import com.bank.injector.ApplicationInjector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AccountDaoImpl extends AbstractCrudPageableDaoImpl<Account> implements AccountDao {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM accounts WHERE id =?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM accounts";
    private static final String SAVE_QUERY = "INSERT INTO accounts (id, user_id, money) values(?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE accounts SET user_id = ?, money = ? WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM accounts WHERE id = ?";

    public AccountDaoImpl(ConnectorToDB connector) {
        super(connector, FIND_BY_ID_QUERY, FIND_ALL_QUERY, SAVE_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    protected Account mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        UserDao userDao = ApplicationInjector.getUserDao();
        Optional<User> user = userDao.findById(resultSet.getInt("user_id"));
        if (!user.isPresent()) {
            throw new SQLException("Account has no user");
        }
        return Account.builder()
                .withId(resultSet.getInt("id"))
                .withId(user.get().getId())
                .withMoney(resultSet.getInt("money"))
                .build();
    }

    @Override
    protected void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, Account entity) throws SQLException {
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setInt(2, entity.getUser().getId());
        preparedStatement.setInt(3, entity.getMoney());
    }

    @Override
    protected void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, Account entity) throws SQLException {
        preparedStatement.setInt(2, entity.getUser().getId());
        preparedStatement.setInt(3, entity.getMoney());
        preparedStatement.setInt(1, entity.getId());
    }

    @Override
    protected void fillPreparedStatementForDeleteByIdQuery(PreparedStatement preparedStatement, Account entity) throws SQLException {
        preparedStatement.setInt(1, entity.getId());
    }
}
