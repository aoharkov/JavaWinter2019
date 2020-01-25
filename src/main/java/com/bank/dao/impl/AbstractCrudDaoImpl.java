package com.bank.dao.impl;

import com.bank.dao.CrudDao;
import com.bank.dao.util.ConnectorToDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E> {
    private static final Logger LOGGER = LogManager.getLogger(AbstractCrudDaoImpl.class);

    protected final ConnectorToDB connector;
    private final String findByIdQuery;
    private final String findAllQuery;

    public AbstractCrudDaoImpl(ConnectorToDB connector, String findByIdQuery, String findAllQuery) {
        this.connector = connector;
        this.findByIdQuery = findByIdQuery;
        this.findAllQuery = findAllQuery;
    }

    @Override
    public List<E> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Optional<E> findById(Integer id) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(findByIdQuery)) {
            preparedStatement.setInt(1, id);
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

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    @Override
    public void save(E entity) {

    }

    @Override
    public void update(E entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

}
