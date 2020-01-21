package practice.lesson2.useaassigleton;

import static java.util.Objects.isNull;

//We wants to have to use a as singleton
public final class B {
    private String description;
    private final A a;

    public B(String description, A a) {
        this.description = description;
        this.a = copyA(a);
    }

    private A copyA(A a) {
        return isNull(a) ? null :  new A(a.getCode());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public A getA() {
        return copyA(a);
    }

    @Override
    public String toString() {
        return "B{" +
                "description='" + description + '\'' +
                ", a=" + a +
                '}';
    }
}
