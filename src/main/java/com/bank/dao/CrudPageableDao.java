package com.bank.dao;

import com.bank.dao.domain.Pageable;

public interface CrudPageableDao<E> extends CrudDao<E> {

    Pageable<E> findAll(int page, int itemsPerPage);

    long count();
}
