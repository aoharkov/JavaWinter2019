package org.lesson1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //final A a = new A();
        final Class<A> aClass = A.class;
        final Constructor<A> constructor = aClass.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        final A a = constructor.newInstance(1);
        //a.method();
        final Method method = aClass.getDeclaredMethod("method");
        method.setAccessible(true);
        final Object invoke = method.invoke(a);
        //A.staticMethod();
        final Method staticMethod = aClass.getDeclaredMethod("staticMethod");
        staticMethod.setAccessible(true);
        final Object invoke2 = staticMethod.invoke(null);
    }
}

class A {
    private A(int i) {
        System.out.println(i);
    }

    private void method() {
        System.out.println("Nonstatic method");
    }

    private static void staticMethod() {
        System.out.println("Static method");
    }
}
