package com.bank.dao.util;

import java.util.List;

public interface Pageable<T> {
    List<T> getItems();

    int getPageNumber();

    int getItemsNumberPerPage();

    int getMaxPage();

}
