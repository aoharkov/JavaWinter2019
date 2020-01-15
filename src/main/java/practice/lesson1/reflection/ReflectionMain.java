package practice.lesson1.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        demo();
    }

    private static void demo() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //instead of {@code final A a = new A();}
        final Class<A> aClass = A.class;
        final Constructor<A> constructor = aClass.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        final A a = constructor.newInstance(1);
        ////instead of {@code a.method();}
        final Method method = aClass.getDeclaredMethod("method");
        method.setAccessible(true);
        final Object invoke = method.invoke(a);
        ////instead of {@code A.staticMethod();}
        final Method staticMethod = aClass.getDeclaredMethod("staticMethod");
        staticMethod.setAccessible(true);
        final Object invoke2 = staticMethod.invoke(null);
    }
}

