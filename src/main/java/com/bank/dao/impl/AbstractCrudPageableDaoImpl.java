package com.bank.dao.impl;

import com.bank.dao.CrudPageableDao;
import com.bank.dao.domain.Pageable;
import com.bank.dao.util.ConnectorToDB;

public abstract class AbstractCrudPageableDaoImpl<E> extends AbstractCrudDaoImpl<E> implements CrudPageableDao<E> {

    public AbstractCrudPageableDaoImpl(ConnectorToDB connector, String findByIdQuery, String findAllQuery, String saveQuery, String updateQuery, String deleteQuery) {
        super(connector, findByIdQuery, findAllQuery, saveQuery, updateQuery, deleteQuery);
    }

    @Override
    public Pageable<E> findAll(int page, int itemsPerPage) {
        long numberOfItemsToSkip = (page - 1) * (long) itemsPerPage;
        int maxPage = (int) ((count() + itemsPerPage - 1) / itemsPerPage);
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
