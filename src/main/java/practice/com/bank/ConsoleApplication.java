package practice.com.bank;

import practice.com.bank.injector.ApplicationInjector;
import practice.com.bank.service.UserService;

public class ConsoleApplication {
    public static void main(String[] args) {
        ApplicationInjector injector = ApplicationInjector.getInstance();
        UserService userService = injector.getUserService();
        final boolean password = userService.login("email", "pass");
        System.out.println(password);
    }
}
