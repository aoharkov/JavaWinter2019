package practice.lesson1.tester;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
    public void run(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clazz.getConstructor();
        Object object = constructor.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        //List<Method> testMethods = getMethodsByAnnotation(NewTest.class, methods);
        //List<Method> beforeMethods = getMethodsByAnnotation(NewBefore.class, methods);
        for (Method method:methods) {
            //not finished
            if (method.isAnnotationPresent(NewTest.class)) {
                method.invoke(object);
            }
        }
    }

//    private List<Method> getMethodsByAnnotation(Class<?> annotation, Method[] methods) {
//        List<Method> tempMethods = new ArrayList<>();
//        for (Method method :
//                methods) {
//            if (method.isAnnotationPresent(annotation)) {
//
//            }
//        }
//    }
}
