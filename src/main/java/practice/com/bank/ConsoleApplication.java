package practice.com.bank;

import practice.com.bank.domain.User;

public class ConsoleApplication {
    public static void main(String[] args) {
        User user1 = new User.Builder()
                .withId(12)
                .withEmail("email")
                .withPassword("123")
                .withAccounts(null)
                .build();
        System.out.println(user1.toString());
    }
}
