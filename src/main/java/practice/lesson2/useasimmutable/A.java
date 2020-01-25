package practice.lesson2.useasimmutable;

//Provided class, which content we cannot change
public class A {
    private int code;

    A(int code) {
        this.code = code;
    }

    int getCode() {
        return code;
    }

    void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "A{" +
                "code=" + code +
                '}';
    }
}
