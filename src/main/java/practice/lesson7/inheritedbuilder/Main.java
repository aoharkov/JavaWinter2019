package practice.lesson7.inheritedbuilder;

public class Main {
    public static void main(String[] args) {
        Client client = new Client.ClientBuilder()
                .withEmail("email")
                .withCode(12)
                .withPassword("qwerty")
                .build();
        System.out.println(client);
    }
}
