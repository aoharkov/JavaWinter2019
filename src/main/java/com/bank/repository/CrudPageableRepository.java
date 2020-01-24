package com.bank.repository;

public interface CrudPageableRepository<E> extends CrudRepository<E> {

    Pageable<E> findAll(int page, int itemsPerPage);

    long count();
}
