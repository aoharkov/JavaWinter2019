package practice.lesson1.tester;

import practice.lesson1.tester.annotations.MyAfterAllAnnotation;
import practice.lesson1.tester.annotations.MyAfterAnnotation;
import practice.lesson1.tester.annotations.MyBeforeAllAnnotation;
import practice.lesson1.tester.annotations.MyBeforeAnnotation;
import practice.lesson1.tester.annotations.MyTestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public void run(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clazz.getConstructor();
        Object object = constructor.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> testMethods = getMethodsByAnnotation(MyTestAnnotation.class, methods);
        List<Method> beforeMethods = getMethodsByAnnotation(MyBeforeAnnotation.class, methods);
        List<Method> afterMethods = getMethodsByAnnotation(MyAfterAnnotation.class, methods);
        List<Method> beforeAllMethods = getMethodsByAnnotation(MyBeforeAllAnnotation.class, methods);
        List<Method> afterAllMethods = getMethodsByAnnotation(MyAfterAllAnnotation.class, methods);
        for (Method beforeAllMethod : beforeAllMethods) {
            beforeAllMethod.invoke(null);
        }
        for (Method testMethod : testMethods) {
            for (Method beforeMethod : beforeMethods) {
                beforeMethod.invoke(object);
            }
            testMethod.invoke(object);
            for (Method afterMethod : afterMethods) {
                afterMethod.invoke(object);
            }
        }
        for (Method afterAllMethod : afterAllMethods) {
            afterAllMethod.invoke(null);
        }
    }

    private List<Method> getMethodsByAnnotation(Class<? extends Annotation> annotation, Method[] methods) {
        List<Method> tempMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotation)) {
                tempMethods.add(method);
            }
        }
        return tempMethods;
    }
}
