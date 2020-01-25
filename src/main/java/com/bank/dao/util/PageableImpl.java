package com.bank.dao.util;

import java.util.List;

public class PageableImpl<T> implements Pageable {
    private final List<T> items;
    private final int pageNumber;
    private final int itemsNumberPerPage;
    private final int maxPage;

    private PageableImpl(Builder builder) {
        this.items = builder.items;
        this.pageNumber = builder.pageNumber;
        this.itemsNumberPerPage = builder.itemsNumberPerPage;
        this.maxPage = builder.maxPage;
    }

    public static<T2> Builder builder() {
        return new Builder();
    }

    @Override
    public List<T> getItems() {
        return items;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getItemsNumberPerPage() {
        return itemsNumberPerPage;
    }

    @Override
    public int getMaxPage() {
        return maxPage;
    }

    public static class Builder<T1> {
        private List<T1> items;
        private int pageNumber;
        private int itemsNumberPerPage;
        private int maxPage;

        Builder() {
            //Used as starting point in Builder pattern
        }

        public PageableImpl build() {
            return new PageableImpl(this);
        }

        public Builder withItems(List<T1> items) {
            this.items = items;
            return this;
        }

        public Builder withPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public Builder withItemsNumberPerPage(int itemsNumberPerPage) {
            this.itemsNumberPerPage = itemsNumberPerPage;
            return this;
        }

        public Builder withMaxPage(int maxPage) {
            this.maxPage = maxPage;
            return this;
        }
    }
}
