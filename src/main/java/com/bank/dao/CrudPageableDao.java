package com.bank.dao;

import com.bank.dao.util.Pageable;

public interface CrudPageableDao<E> extends CrudDao<E> {

    Pageable<E> findAll(int page, int itemsPerPage);

    long count();
}
