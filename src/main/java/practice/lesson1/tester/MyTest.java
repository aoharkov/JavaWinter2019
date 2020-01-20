package practice.lesson1.tester;

import practice.lesson1.tester.annotations.MyAfterAnnotation;
import practice.lesson1.tester.annotations.MyAfterAllAnnotation;
import practice.lesson1.tester.annotations.MyBeforeAnnotation;
import practice.lesson1.tester.annotations.MyBeforeAllAnnotation;
import practice.lesson1.tester.annotations.MyTestAnnotation;

public class MyTest {
    @MyBeforeAllAnnotation
    public void beforeAll1() {
        System.out.println("================\nbeforeAll 1\n================");
    }
    @MyBeforeAnnotation
    public void before1() {
        System.out.println("before 1");
    }

    @MyAfterAnnotation
    public void after1() {
        System.out.println("after 1\n----------------");
    }

    @MyAfterAllAnnotation
    public void afterAll1() {
        System.out.println("afterAll 1\n================");
    }

    @MyTestAnnotation
    public void test1() {
        System.out.println("test1");
    }

    @MyTestAnnotation
    public void test2() {
        System.out.println("test2");
    }

    @MyTestAnnotation(expectedException = IllegalArgumentException.class, expectedMessage = "operator is null")
    public void testShouldReturnIllegalArgumentException() {
        System.out.println("testShouldReturnIllegalArgumentException");
    }

    private void noTest() {
        System.out.println("not a test");
    }
}
