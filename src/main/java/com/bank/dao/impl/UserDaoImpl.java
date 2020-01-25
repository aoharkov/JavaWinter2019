package com.bank.dao.impl;

import com.bank.dao.UserDao;
import com.bank.dao.util.ConnectorToDB;
import com.bank.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl extends AbstractCrudPageableDaoImpl<User> implements UserDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);
    private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email =?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id =?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";

    public UserDaoImpl(ConnectorToDB connector) {
        super(connector, FIND_BY_ID_QUERY, FIND_ALL_QUERY);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(FIND_BY_EMAIL_QUERY)) {
            preparedStatement.setString(1, email);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapResultSetToEntity(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return Optional.empty();
    }

    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .withId(resultSet.getInt("id"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .build();
    }
}
