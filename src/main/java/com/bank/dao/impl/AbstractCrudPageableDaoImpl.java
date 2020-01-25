package com.bank.dao.impl;

import com.bank.dao.CrudPageableDao;
import com.bank.dao.util.ConnectorToDB;
import com.bank.dao.util.Pageable;


public abstract class AbstractCrudPageableDaoImpl<E> extends AbstractCrudDaoImpl<E> implements CrudPageableDao<E> {

    public AbstractCrudPageableDaoImpl(ConnectorToDB connector, String findById, String findAllQuery) {
        super(connector, findById, findAllQuery);
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
