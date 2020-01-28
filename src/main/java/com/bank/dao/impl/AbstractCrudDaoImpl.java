package com.bank.dao.impl;

import com.bank.dao.CrudDao;
import com.bank.dao.util.ConnectorToDB;
import com.bank.dao.util.DataBaseSqlRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E> {
    private static final Logger LOGGER = LogManager.getLogger(AbstractCrudDaoImpl.class);
    private static final BiConsumer<PreparedStatement, Integer> INT_PARAM_SETTER = ((preparedStatement, integer) -> {
        try {
            preparedStatement.setInt(1, integer);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    });
    private static final BiConsumer<PreparedStatement, String> STRING_PARAM_SETTER = ((preparedStatement, str) -> {
        try {
            preparedStatement.setString(1, str);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    });

    protected final ConnectorToDB connector;
    private final String findByIdQuery;
    private final String findAllQuery;
    private final String saveQuery;
    private final String updateQuery;
    private final String deleteQuery;

    public AbstractCrudDaoImpl(ConnectorToDB connector, String findByIdQuery, String findAllQuery, String saveQuery, String updateQuery, String deleteQuery) {
        this.connector = connector;
        this.findByIdQuery = findByIdQuery;
        this.findAllQuery = findAllQuery;
        this.saveQuery = saveQuery;
        this.updateQuery = updateQuery;
        this.deleteQuery = deleteQuery;
    }

    @Override
    public void save(E entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveQuery)) {

            fillPreparedStatementForSaveQuery(preparedStatement, entity);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
    }

    protected abstract void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, E entity) throws SQLException;

    @Override
    public Optional<E> findById(Integer id) {
        return findByParam(id, findByIdQuery, INT_PARAM_SETTER);
    }

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected <P>Optional<E> findByParam(P param, String sqlQuery,
                                         BiConsumer<PreparedStatement, P> designedParamSetting) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(sqlQuery)) {

            designedParamSetting.accept(preparedStatement, param);

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapResultSetToEntity(resultSet));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public List<E> findAll() {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery)) {

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                List<E> entities = new ArrayList<>();
                while (resultSet.next()) {
                    entities.add(mapResultSetToEntity(resultSet));
                }
                return entities;
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void update(E entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            fillPreparedStatementForUpdateQuery(preparedStatement, entity);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
    }

    protected abstract void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, E entity) throws SQLException;

    @Override
    public void deleteById(Integer id) {
        Optional<E> entity = findById(id);
        if (entity.isPresent()) {
            try (Connection connection = connector.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

                fillPreparedStatementForDeleteByIdQuery(preparedStatement, entity.get());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                throw new DataBaseSqlRuntimeException(e.getMessage(), e);
            }
        }
    }

    protected abstract void fillPreparedStatementForDeleteByIdQuery(PreparedStatement preparedStatement, E entity) throws SQLException;
}
