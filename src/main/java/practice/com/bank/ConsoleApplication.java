package practice.com.bank;

import practice.com.bank.domain.Account;
import practice.com.bank.domain.User;

public class ConsoleApplication {
    public static void main(String[] args) {
        User user1 = User.builder()
                .withId(1)
                .withEmail("email1")
                .withPassword("1111")
                .withAccounts(null)
                .build();
        System.out.println(user1);

        Account account1 = Account.builder()
                .withId(1)
                .withMoney(100)
                .withUser(user1)
                .build();
        System.out.println(account1);
    }
}
