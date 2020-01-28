package com.bank.entity;

import java.util.Objects;

public class Account {
    private final Integer id;
    private final User user;
    private final Integer money;

    private Account(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.money = builder.money;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", userId=" + user.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return id.equals(account.id) &&
                Objects.equals(user, account.user) &&
                Objects.equals(money, account.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, money);
    }

    public static class Builder {
        private Integer id;
        private User user;
        private Integer money;

        Builder() {
            //Used as starting point in Builder pattern
        }

        public Account build() {
            return new Account(this);
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withUser(User user) {
            this.user = user;
            return this;
        }

        public Builder withMoney(Integer money) {
            this.money = money;
            return this;
        }
    }
}
