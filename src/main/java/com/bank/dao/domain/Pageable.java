package com.bank.dao.domain;

import java.util.List;

public interface Pageable<T> {
    List<T> getItems();

    int getPageNumber();

    int getItemsNumberPerPage();

    int getMaxPage();

}
