package com.bank.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<E> {

    List<E> findAll();

    Optional<E> findById(Integer id);

    void save(E entity);

    void update(E entity);

    void deleteById(Integer id);

}
