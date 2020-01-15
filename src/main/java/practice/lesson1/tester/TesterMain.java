package practice.lesson1.tester;

import java.lang.reflect.InvocationTargetException;

public class TesterMain {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        new TestRunner().run(MyTest.class);
    }
}
