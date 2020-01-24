package com.bank.view;

import com.bank.injector.ApplicationInjector;
import com.bank.service.UserService;

public class View {
    private ConsoleInput input = new ConsoleInput();
    private UserService userService = ApplicationInjector.getUserService();
    /*public void findUserDialog(){
        int command = 0;
        do {
            showFindUserDialog();
            command = input.nextInt();
            switch (command){
                case 1:
                    String email = input.nextLine();
                    String password = input.nextLine();
                    userService.login(email, password);
                    break;
                case 2:
                    User user = User.builder()
                            .withId(1)
                            .withEmail(email)
                            .withPassword(password)
                            .withAccounts(null)
                            .build();
                    userService.register(user);
                    break;
            }
        } while(command != 0);
    }*/

    private void showFindUserDialog() {
        String message = "Please, enter\n" +
                "     * 1 - to login\n" +
                "     * 2 - to register\n" +
                "     * 0 - to exit";
        System.out.println(message);
    }
    /**
     * 1 - to login
     * 2 - to register
     * 0 - exit
     *
     * ----
     * 1 - find by id
     * 2 find by id
     * 3 find by email
     *
     * also print number of pages
     *
     */
}
