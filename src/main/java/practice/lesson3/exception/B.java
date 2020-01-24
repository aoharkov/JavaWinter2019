package practice.lesson3.exception;

public class B {

    public static void main(String[] args) {
        validate(100);
    }

    private static void validate(int n) {
        try {
            throw null;
        } finally {
            throw new RuntimeException("finally");
        }
    }
}
